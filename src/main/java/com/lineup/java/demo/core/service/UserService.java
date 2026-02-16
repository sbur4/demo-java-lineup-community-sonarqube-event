package com.lineup.java.demo.core.service;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;

import java.util.List;

public interface UserService {

    List<ResponseUserDto> findAllUsers();

    UserDto findUserById(String id);

    ResponseUserDto findUserByEmail(String id);

    ResponseUserDto createUser(CreateUserDto dto);

    ResponseUserDto fullUpdateUserById(String id);

    ResponseUserDto partialUpdateUserById(String id);

    Void deleteUserById(String id);
}
