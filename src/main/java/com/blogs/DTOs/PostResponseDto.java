package com.blogs.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private UserDto user;
}
