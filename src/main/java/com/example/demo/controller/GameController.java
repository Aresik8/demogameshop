package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;
import com.example.demo.model.request.UpdateGameRequest;
import com.example.demo.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Игры")
@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Получить игру по ID")
    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @Operation(summary = "Получить все игры")
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.findAll();
    }

    @Operation(summary = "Создать игру")
    @PostMapping
    public Game createGame(@Valid @RequestBody CreateGameRequest request) {
        return gameService.create(request);
    }

    @Operation(summary = "Обновить игру")
    @PatchMapping("/{id}")
    public Game updateGame(@PathVariable Long id,
                           @Valid @RequestBody UpdateGameRequest request) {
        return gameService.update(id, request);
    }

    @Operation(summary = "Удалить игру")
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.delete(id);
    }
}