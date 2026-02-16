package com.lineup.java.demo.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized // NOTE: Crucial: Allows Jackson to use the Lombok builder for deserialization
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // NOTE: Converts username to user_name, etc.
public class ResponseUserDto {

    String id;
    String username;
    String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
