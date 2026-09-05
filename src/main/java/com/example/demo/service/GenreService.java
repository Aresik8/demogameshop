package com.example.demo.service;

import com.example.demo.model.Genre;
import java.util.List;

public interface GenreService {
    Genre findById(Long id);
    List<Genre> findAll();
    Genre create(String name);
    Genre updateName(Long id, String newName);
    void delete(Long id);
}