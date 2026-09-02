package com.example.demo.dao;

import com.example.demo.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreDao {
    Genre create(String name);
    void updateName(int id, String newName);
    void delete(int id);
    List<Genre> findAll();
    Optional<Genre> findById(int id);
}


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.stereotype.Repository;
//import com.example.demo.dao.dto.GenreDto;
//
//import java.util.UUID;
//
//@Repository
//public interface GenreDao extends JpaRepository<GenreDto, UUID>, JpaSpecificationExecutor<GenreDto> {
//}
