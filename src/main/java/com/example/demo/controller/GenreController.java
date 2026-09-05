package com.example.demo.controller;

import com.example.demo.service.GenreService;
import com.example.demo.model.Genre;
import com.example.demo.model.request.GenreRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Жанры")
@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @Operation(summary = "Получить жанр по ID")
    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @Operation(summary = "Получить все жанры")
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.findAll();
    }

    @Operation(summary = "Создать жанр")
    @PostMapping
    public Genre createGenre(@Valid @RequestBody GenreRequest request) {
        return genreService.create(request.getName());
    }

    @Operation(summary = "Обновить название жанра")
    @PatchMapping("/{id}")
    public Genre updateGenreName(@PathVariable Long id,
                                 @Valid @RequestBody GenreRequest request) {
        return genreService.updateName(id, request.getName());
    }

    @Operation(summary = "Удалить жанр")
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
    }
}
