package com.lineup.java.demo.web.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http2.config.H2Config;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class ApacheHttpClient5Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient());
        return factory;
    }

    @Bean
    public HttpClient httpClient() {
        // Configure connection pool
        PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setDefaultConnectionConfig(ConnectionConfig.custom()
                        .setConnectTimeout(Timeout.ofSeconds(30))
                        .setSocketTimeout(Timeout.ofSeconds(30))
                        .setTimeToLive(1, TimeUnit.HOURS)
                        .build())
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(20)
                .build();

        // Configure HTTP/2 and HTTP/3 support
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofSeconds(30))
                .setResponseTimeout(Timeout.ofSeconds(30))
                .build();

        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
//                .setVersionPolicy(HttpVersionPolicy.NEGOTIATE) // Negotiate best protocol (HTTP/3, HTTP/2, HTTP/1.1)
                .build();
    }

    @Bean
    public CloseableHttpAsyncClient http3AsyncClient() {
        // Configure HTTP/3 specific settings
        IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setSoTimeout(Timeout.ofSeconds(30))
                .setTcpNoDelay(true)
                .setSoReuseAddress(true)
                .build();

        H2Config h2Config = H2Config.custom()
                .setPushEnabled(false)
                .build();

        return HttpAsyncClients.customHttp2()
                .setIOReactorConfig(ioReactorConfig)
//                .setVersionPolicy(HttpVersionPolicy.FORCE_HTTP_3) // Force HTTP/3/
                .build();
    }
}