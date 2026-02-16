package com.lineup.java.demo.data.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan("com.lineup.java.demo.data.entity")
@EnableJpaRepositories(basePackages = "com.lineup.java.demo.data.repository")
public class JpaConfig {
}
