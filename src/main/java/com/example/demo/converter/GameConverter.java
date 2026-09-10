package com.example.demo.converter;

import com.example.demo.dao.dto.GameDto;
import com.example.demo.model.Game;

public class GameConverter {

    public void fromDto(GameDto source, Game destination) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setPrice(source.getPrice());
        destination.setPlayerQuantity(source.getPlayerQuantity());
        destination.setDeveloper(source.getDeveloper());
        destination.setReleaseDate(source.getReleaseDate());
        destination.setDescription(source.getDescription());
        destination.setSystemRequirements(source.getSystemRequirements());
    }
}