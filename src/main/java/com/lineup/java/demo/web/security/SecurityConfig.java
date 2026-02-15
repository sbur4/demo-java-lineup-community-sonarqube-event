//package com.lineup.java.demo.web.security;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        return http
//                .authorizeExchange(exchanges -> exchanges
//                        .pathMatchers("/login", "/public/**").permitAll()
//                        .anyExchange().authenticated()
//                )
//                .formLogin(withDefaults()) // Enables default login page
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                )
//                .csrf(csrf -> csrf.disable()) // Disable for simplicity in demos
//                .build();
//    }
//
//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("user")
//                .password("{noop}password")
//                .roles("USER")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }
//}
