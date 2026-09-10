package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;
import com.example.demo.model.request.UpdateGameRequest;

import java.util.List;
import java.util.UUID;

public interface GameService {
    Game getGameById(UUID id);
    List<Game> getAllGames();
    Game createGame(CreateGameRequest request);
    void deleteGame(UUID id);
    Game updateGame(UUID id, UpdateGameRequest request);
}