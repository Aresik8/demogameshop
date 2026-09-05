package com.example.demo.service;

import com.example.demo.dao.GenreDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    @Transactional(readOnly = true)
    public Genre findById(Long id) {
        return genreDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Жанр не найден"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    @Transactional
    public Genre create(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genreDao.save(genre);
    }

    @Override
    @Transactional
    public Genre updateName(Long id, String newName) {
        genreDao.updateName(id, newName);
        return findById(id); // повторно запрашиваем для возврата актуальных данных
    }

    @Override
    @Transactional
    public void delete(Long id) {
        genreDao.deleteById(id);
    }
}