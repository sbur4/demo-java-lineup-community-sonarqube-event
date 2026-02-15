package com.lineup.java.demo.web.config;

import org.eclipse.jetty.http3.server.HTTP3ServerConnectionFactory;
import org.eclipse.jetty.quic.server.QuicServerConnector;
import org.eclipse.jetty.server.Server;
import org.springframework.boot.jetty.servlet.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyHttp3Config {

    @Bean
    public JettyServletWebServerFactory jettyFactory() {
        // todo check how it works
        return new JettyServletWebServerFactory() {

            void configureServer(Server server) {
                // --- SSL Context for QUIC/HTTP3 ---
//                SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
//                sslContextFactory.setKeyStorePath("classpath:keystore.jks"); // Place keystore in resources
//                sslContextFactory.setKeyStorePassword("changeit"); // Use your password
//                sslContextFactory.setKeyManagerPassword("changeit"); // Use your password

                // --- HTTP/3 Connection Factory ---
                HTTP3ServerConnectionFactory http3 = new HTTP3ServerConnectionFactory();

                // --- QUIC Connector for HTTP/3 ---
                QuicServerConnector quicConnector = new QuicServerConnector(server, null, http3);
                quicConnector.setPort(8182); //todo

                // --- Add QUIC Connector to Jetty Server ---
                server.addConnector(quicConnector);
            }
        };
    }
}