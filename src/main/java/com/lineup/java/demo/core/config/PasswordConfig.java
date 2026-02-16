package com.lineup.java.demo.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Slf4j
@Configuration
public class PasswordConfig {

    @Bean
    public Argon2PasswordEncoder initArgonPasswordEncoder() {
        log.info("Initializing Argon2PasswordEncoder bean with version '{}'.", 5_8);
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
