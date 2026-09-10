package com.example.demo.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class UpdateGameRequest {
    private Optional<String> name = Optional.empty();
    private Optional<Integer> price = Optional.empty();
    private Optional<String> playerQuantity = Optional.empty();
    private Optional<String> developer = Optional.empty();
    private Optional<LocalDate> releaseDate = Optional.empty();
    private Optional<String> description = Optional.empty();
    private Optional<String> systemRequirements = Optional.empty();
}