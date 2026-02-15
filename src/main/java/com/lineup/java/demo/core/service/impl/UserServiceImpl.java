package com.lineup.java.demo.core.service.impl;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.UserDto;
import com.lineup.java.demo.core.service.UserService;
import com.lineup.java.demo.data.entity.User;
import com.lineup.java.demo.data.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j //todo
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();

        List<UserDto> dtos = new ArrayList<>(); // todo


        return List.of();
    }

    @Override
    public UserDto findById(String id) {
        Optional<User> user = userRepository.findById(id);


        return null;
    }


    @Override
    public UserDto createUser(CreateUserDto dto) {
//        User savedUser = userRepository.save(user);

        return null;
    }

    @Override
    public UserDto fullUpdateById(String id) {
        return null;
    }

    @Override
    public UserDto partialUpdateById(String id) {
        return null;
    }

    @Override
    public Void deleteById(String id) {
        return null;
    }



    // trans
    // multi
}
