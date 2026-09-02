package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/game")
@RestController
public class GameController {

    @GetMapping("/{id}")
    public String getOne(@PathVariable String id) {
        return "Get one for id: %s".formatted(id);
    }

    @GetMapping("/")
    public String getAll(){
        return "Get all";
    }

    @PostMapping("/")
    public String create(){
        return "create";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable String id){
        return "update for id: %s".formatted(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return "delete id: %s".formatted(id);
    }
}
