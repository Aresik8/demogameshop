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
import java.util.UUID;

@Tag(name = "Игры")
@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable UUID id) {
        return gameService.getGameById(id);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping
    public Game createGame(@Valid @RequestBody CreateGameRequest request) {
        return gameService.createGame(request);
    }

    @Operation(summary = "Удалить игру",
            description = "Удаляет игру по ID")
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable UUID id) {
        gameService.deleteGame(id);
    }

    @PatchMapping("/{id}")
    public Game updateGame(@PathVariable UUID id,
                           @Valid @RequestBody UpdateGameRequest request) {
        return gameService.updateGame(id, request);
    }
}