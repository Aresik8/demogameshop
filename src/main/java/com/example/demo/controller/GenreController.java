package com.example.demo.controller;

import com.example.demo.dao.GenreDao;
import com.example.demo.model.Genre;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Жанры")
@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreDao genreDao;

    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable int id) {
        return genreDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Жанр не найден"));
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreDao.findAll();
    }

    @PostMapping
    public Genre createGenre(@Valid @RequestBody CreateGenreRequest request) {
        return genreDao.create(request.getName());
    }

    @Operation(summary = "Обновить название жанра",
            description = "Обновляет название жанра по его ID")
    @PatchMapping("/{id}")
    public Genre updateGenreName(@PathVariable int id,
                                 @Valid @RequestBody UpdateGenreRequest request) {
        genreDao.updateName(id, request.getName());
        return genreDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Жанр не найден"));
    }

    @Operation(summary = "Удалить жанр",
            description = "Удаляет жанр по ID")
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable int id) {
        genreDao.delete(id);
    }

    // DTO-классы для запросов (можно вынести в отдельные файлы)
 // public record CreateGenreRequest(String name) {}
 // public record UpdateGenreRequest(String name) {}
}
