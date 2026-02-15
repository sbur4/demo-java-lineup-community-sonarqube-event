package com.lineup.java.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.lineup.java.demo.data.entity")
@EnableJpaRepositories("com.lineup.java.demo.data.repository")
public class DemoApplication {

    void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
