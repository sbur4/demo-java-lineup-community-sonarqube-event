package com.lineup.java.demo.core.service;

import com.lineup.java.demo.core.dto.CreateUserDto;
import com.lineup.java.demo.core.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(String id);

    UserDto createUser(CreateUserDto dto);

    UserDto fullUpdateById(String id);

    UserDto partialUpdateById(String id);

    Void deleteById(String id);
}
