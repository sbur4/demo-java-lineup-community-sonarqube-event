package com.lineup.java.demo.core.service.impl;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;
import com.lineup.java.demo.core.mapper.UserMapper;
import com.lineup.java.demo.core.service.UserService;
import com.lineup.java.demo.data.entity.User;
import com.lineup.java.demo.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j //todo
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<ResponseUserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<ResponseUserDto> dtos = userMapper.toDtoList(users);
        return dtos;
    }

    @Override
    public ResponseUserDto findUserById(String id) {
        Optional<User> user = userRepository.findById(id).orElseThrow();
        ResponseUserDto dto = userMapper.toDto(user.get());
        return dto;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return null;
    }


    @Override
    public UserDto createUser(CreateUserDto dto) {
//        User savedUser = userRepository.save(user);

        return null;
    }

    @Override
    public UserDto fullUpdateUserById(String id) {
        return null;
    }

    @Override
    public UserDto partialUpdateUserById(String id) {
        return null;
    }

    @Override
    public Void deleteUserById(String id) {
        return null;
    }


    // trans
    // multi
}
