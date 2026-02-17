package com.lineup.java.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lineup.java.demo")
public class DemoApplication {

    void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
// enable async
// dto validation
// todo ex handelr
// sonarcloud.properties
// todo github actions
// terraform
// docker
// jenkins
// k8s
