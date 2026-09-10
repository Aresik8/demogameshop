package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;
import com.example.demo.model.request.UpdateGameRequest;

import java.util.List;

public interface GameService {
    Game findById(Long id);
    List<Game> findAll();
    Game create(CreateGameRequest request);
    Game update(Long id, UpdateGameRequest request);
    void delete(Long id);
}