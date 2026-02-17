package com.lineup.java.demo.web.controller;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;
import com.lineup.java.demo.core.dto.UpdateUserDto;
import com.lineup.java.demo.core.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Async
@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    // NOTE: http://localhost:8181/api/users
    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> findAll() {
        List<ResponseUserDto> response = CompletableFuture
                .supplyAsync(userService::findAllUsers)
                .join();
        return ResponseEntity.ofNullable(response);
    }

    // NOTE: http://localhost:8181/api/users/id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> findById(@PathVariable String id) { // @Valid
        ResponseUserDto response = CompletableFuture
                .supplyAsync(() -> userService.findUserById(id))
                .join();
        return ResponseEntity.ofNullable(response);
    }

    // NOTE: http://localhost:8181/api/users
    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@Valid @RequestBody CreateUserDto dto) { // @Valid
        ResponseUserDto response = CompletableFuture
                .supplyAsync(() -> userService.createUser(dto))
                .join();
        return ResponseEntity.ofNullable(response);
    }

    // NOTE: http://localhost:8181/api/users
    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> fullUpdateById(@Valid @RequestBody UpdateUserDto dto) { // @Valid
        ResponseUserDto response = CompletableFuture
                .supplyAsync(() -> userService.fullUpdateUserById(dto))
                .join();
        return ResponseEntity.ofNullable(response);
    }

    // NOTE: http://localhost:8181/api/users
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseUserDto> partialUpdateById(@Valid @RequestBody UpdateUserDto dto) { // @Valid
        ResponseUserDto response = CompletableFuture
                .supplyAsync(() -> userService.partialUpdateUserById(dto))
                .join();
        return ResponseEntity.ofNullable(response);
    }

    // NOTE: http://localhost:8181/api/users/id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUserDto> deleteById(@PathVariable
                                                          @NotBlank(message = "ID cannot be blank")
//                                                          @Size(min = 3, max = 50, message = "ID must be between 3 and 50 characters")
//                                                          @Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "ID contains invalid characters")
                                                          String id) {
        CompletableFuture
                .runAsync(() -> userService.deleteUserById(id))
                .join();
        return ResponseEntity
                .status(HttpStatusCode.valueOf(204))
                .build();
    }
}
