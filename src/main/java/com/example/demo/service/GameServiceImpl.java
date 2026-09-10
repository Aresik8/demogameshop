package com.example.demo.service;

import com.example.demo.converter.GameConverter;
import com.example.demo.dao.GameDao;
import com.example.demo.dao.dto.GameDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Game;
import com.example.demo.model.request.CreateGameRequest;
import com.example.demo.model.request.UpdateGameRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game getGameById(UUID id) {
        GameDto gameDto = gameDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Игра не найдена"));

        Game game = new Game();
        GameConverter gameConverter = new GameConverter();
        gameConverter.fromDto(gameDto, game);

        return game;
    }

    @Override
    public List<Game> getAllGames() {
        List<GameDto> foundGames = gameDao.findAll();
        List<Game> games = new ArrayList<>(foundGames.size());
        GameConverter gameConverter = new GameConverter();

        for (GameDto gameDto : foundGames) {
            Game game = new Game();
            gameConverter.fromDto(gameDto, game);
            games.add(game);
        }

        return games;
    }

    @Override
    @Transactional
    public Game createGame(CreateGameRequest request) {
        GameDto gameDto = new GameDto();
        gameDto.setName(request.getName());
        gameDto.setPrice(request.getPrice());
        gameDto.setPlayerQuantity(request.getPlayerQuantity());
        gameDto.setDeveloper(request.getDeveloper());
        gameDto.setReleaseDate(request.getReleaseDate());
        gameDto.setDescription(request.getDescription());
        gameDto.setSystemRequirements(request.getSystemRequirements());

        GameDto savedGame = gameDao.save(gameDto);

        Game game = new Game();
        GameConverter gameConverter = new GameConverter();
        gameConverter.fromDto(savedGame, game);

        return game;
    }

    @Override
    @Transactional
    public void deleteGame(UUID id) {
        gameDao.deleteById(id);
    }

    @Override
    @Transactional
    public Game updateGame(UUID id, UpdateGameRequest request) {
        GameDto gameDto = gameDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Игра не найдена"));

        request.getName().ifPresent(gameDto::setName);
        request.getPrice().ifPresent(gameDto::setPrice);
        request.getPlayerQuantity().ifPresent(gameDto::setPlayerQuantity);
        request.getDeveloper().ifPresent(gameDto::setDeveloper);
        request.getReleaseDate().ifPresent(gameDto::setReleaseDate);
        request.getDescription().ifPresent(gameDto::setDescription);
        request.getSystemRequirements().ifPresent(gameDto::setSystemRequirements);

        GameDto savedGame = gameDao.save(gameDto);

        Game game = new Game();
        GameConverter gameConverter = new GameConverter();
        gameConverter.fromDto(savedGame, game);

        return game;
    }
}