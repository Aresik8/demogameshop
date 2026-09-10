package com.example.demo.service;

import com.example.demo.converter.GameConverter;
import com.example.demo.dao.GameDao;
import com.example.demo.dao.entity.GameEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;
import com.example.demo.model.request.UpdateGameRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Game findById(Long id) {
        GameEntity gameEntity = gameDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Игра не найдена"));

        Game game = new Game();
        GameConverter gameConverter = new GameConverter();
        gameConverter.fromEntity(gameEntity, game);

        return game;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Game> findAll() {
        List<GameEntity> foundGames = gameDao.findAll();
        List<Game> games = new ArrayList<>(foundGames.size());
        GameConverter gameConverter = new GameConverter();

        for (GameEntity gameEntity : foundGames) {
            Game game = new Game();
            gameConverter.fromEntity(gameEntity, game);
            games.add(game);
        }

        return games;
    }

    @Override
    @Transactional
    public Game create(CreateGameRequest request) {
        GameConverter gameConverter = new GameConverter();
        GameEntity gameEntity = gameConverter.fromCreateRequestToEntity(request);

        GameEntity savedGame = gameDao.save(gameEntity);

        Game game = new Game();
        gameConverter.fromEntity(savedGame, game);

        return game;
    }

    @Override
    @Transactional
    public Game update(Long id, UpdateGameRequest request) {
        GameEntity gameEntity = gameDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Игра не найдена"));

        request.getName().ifPresent(gameEntity::setName);
        request.getPrice().ifPresent(gameEntity::setPrice);
        request.getPlayerQuantity().ifPresent(gameEntity::setPlayerQuantity);
        request.getDeveloper().ifPresent(gameEntity::setDeveloper);
        request.getReleaseDate().ifPresent(gameEntity::setReleaseDate);
        request.getDescription().ifPresent(gameEntity::setDescription);
        request.getSystemRequirements().ifPresent(gameEntity::setSystemRequirements);

        GameEntity savedGame = gameDao.save(gameEntity);

        Game game = new Game();
        GameConverter gameConverter = new GameConverter();
        gameConverter.fromEntity(savedGame, game);

        return game;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        gameDao.deleteById(id);
    }
}