package com.lineup.java.demo.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized // NOTE: Crucial: Allows Jackson to use the Lombok builder for deserialization //todo
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // NOTE: Converts username to user_name, etc.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUserDto {

    @JsonSerialize(using = ToStringSerializer.class)
    String id;

    String username;

    String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
