package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Genre {
    private UUID id;
    private String name;
}
