package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreRequest {
    @NotBlank(message = "Название жанра не может быть пустым")
    @Size(min = 1, max = 100, message = "Название должно быть от 1 до 100 символов")
    private String name;
}