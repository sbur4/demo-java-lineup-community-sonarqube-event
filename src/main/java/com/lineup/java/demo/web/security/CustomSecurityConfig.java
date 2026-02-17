package com.lineup.java.demo.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) ->
                        authorize
//                        authorize.requestMatchers("/users/**")
//                        .authenticated()
                                .anyRequest()
                                .permitAll())
                .formLogin(withDefaults());
        return http.build();
    }

//    @Bean
//    WebSecurityCustomizer ignoringCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**");
//    }
//
//    @Bean
//    WebSecurityCustomizer debugSecurity() {
//        return (web) -> web.debug(true);
//    }

//    @Bean
//    HttpFirewall allowHttpMethod() {
//        List<String> allowedMethods = new ArrayList<String>();
//        allowedMethods.add("GET");
//        allowedMethods.add("POST");
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowedHttpMethods(allowedMethods);
//        return firewall;
//    }
//
//    @Bean
//    WebSecurityCustomizer fireWall() {
//        return (web) -> web.httpFirewall(allowHttpMethod());
//    }

}
