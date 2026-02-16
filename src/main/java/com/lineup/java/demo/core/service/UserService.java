package com.lineup.java.demo.core.service;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;

import java.util.List;

public interface UserService {

    List<ResponseUserDto> findAllUsers();

    UserDto findUserById(String id);

    UserDto findUserByEmail(String id);

    UserDto createUser(CreateUserDto dto);

    UserDto fullUpdateUserById(String id);

    UserDto partialUpdateUserById(String id);

    Void deleteUserById(String id);
}
