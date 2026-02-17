package com.lineup.java.demo.core.dto;

import lombok.Data;

@Data
public class UpdateUserDto {

    private String username;
    private String rawPassword;
    private String text;
}
