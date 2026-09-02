package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Game {
    private UUID id;
    private String name;
    private int price;
    private String playerQuantity;
    private String developer;
    private Date releaseDate;
    private Text description;
    private Text systemRequirements;
}
