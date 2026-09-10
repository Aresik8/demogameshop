package com.example.demo.dao.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "games")
@Getter
@Setter
public class GameDto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "player_quantity", length = 50)
    private String playerQuantity;

    @Column(length = 100)
    private String developer;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "system_requirements", columnDefinition = "TEXT")
    private String systemRequirements;
}