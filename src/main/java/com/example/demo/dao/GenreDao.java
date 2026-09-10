package com.example.demo.dao;

import com.example.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
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
