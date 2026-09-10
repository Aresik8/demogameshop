package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateGameRequest {
    private String name;
    private Integer price;
    private String playerQuantity;
    private String developer;
    private LocalDate releaseDate;
    private String description;
    private String systemRequirements;
}