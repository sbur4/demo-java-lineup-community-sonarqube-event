package com.lineup.java.demo.web.controller;

import com.lineup.java.demo.core.dto.UserDto;
import com.lineup.java.demo.core.service.impl.UserServiceImpl;
import com.lineup.java.demo.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    // NOTE: http://localhost:8181/api/users
    @GetMapping()
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.of(Optional.ofNullable(userService.findAll()));
    }

    // NOTE: http://localhost:8181/api/users/id
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(null));
    }

    // NOTE: http://localhost:8181/api/users
    @PostMapping()
    public ResponseEntity<User> createUser() {
        return ResponseEntity.of(Optional.ofNullable(null));
    }

    // NOTE: http://localhost:8181/api/users/id
    @PutMapping("/{id}")
    public ResponseEntity<User> fullUpdateById(@PathVariable String id) {
        return ResponseEntity.of(Optional.ofNullable(null));
    }

    // NOTE: http://localhost:8181/api/users/id
    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdateById(@PathVariable String id) {
        return ResponseEntity.of(Optional.ofNullable(null));
    }

    // NOTE: http://localhost:8181/api/users/id
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(null));
    }
}

