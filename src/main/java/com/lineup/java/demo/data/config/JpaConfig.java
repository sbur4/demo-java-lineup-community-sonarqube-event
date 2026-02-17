package com.lineup.java.demo.data.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
@EntityScan("com.lineup.java.demo.data.entity")
@EnableJpaRepositories(
        basePackages = "com.lineup.java.demo.data.repository",
        repositoryImplementationPostfix = "Impl",
        namedQueriesLocation = "classpath*:META-INF/jpa-named-queries.properties" //todo
)
public class JpaConfig {

    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
