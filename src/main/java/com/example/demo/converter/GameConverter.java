package com.example.demo.converter;

import com.example.demo.dao.entity.GameEntity;
import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;

public class GameConverter {

    public void fromEntity(GameEntity source, Game destination) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setPrice(source.getPrice());
        destination.setPlayerQuantity(source.getPlayerQuantity());
        destination.setDeveloper(source.getDeveloper());
        destination.setReleaseDate(source.getReleaseDate());
        destination.setDescription(source.getDescription());
        destination.setSystemRequirements(source.getSystemRequirements());
    }

    public GameEntity fromCreateRequestToEntity(CreateGameRequest request) {
        GameEntity gameEntity = new GameEntity();
        GameEntity.setName(request.getName());
        gameEntity.setPrice(request.getPrice());
        gameEntity.setPlayerQuantity(request.getPlayerQuantity());
        gameEntity.setDeveloper(request.getDeveloper());
        gameEntity.setReleaseDate(request.getReleaseDate());
        gameEntity.setDescription(request.getDescription());
        gameEntity.setSystemRequirements(request.getSystemRequirements());
        return gameEntity;
    }
}