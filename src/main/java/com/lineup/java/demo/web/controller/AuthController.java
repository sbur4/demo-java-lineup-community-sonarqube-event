package com.lineup.java.demo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // NOTE: http://localhost:8181/api/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Welcome back, " + "EPAM" + "!");
    }

    // NOTE: http://localhost:8181/api/auth/logout
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Welcome back, " + "EPAM" + "!");
    }
}
