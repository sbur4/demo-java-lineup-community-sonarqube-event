package com.lineup.java.demo.core.service;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.ResponseUserDto;
import com.lineup.java.demo.core.dto.UpdateUserDto;

import java.util.List;

public interface UserService {

    List<ResponseUserDto> findAllUsers();

    ResponseUserDto findUserById(String id);

    ResponseUserDto findUserByEmail(String email);

    ResponseUserDto createUser(CreateUserDto dto);

    ResponseUserDto fullUpdateUserById(UpdateUserDto dto);

    ResponseUserDto partialUpdateUserById(UpdateUserDto dto);

    void deleteUserById(String id);
}
