package com.example.demo.dao;

import com.example.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {

    @Modifying
    @Query("UPDATE Genre g SET g.name = :newName WHERE g.id = :id")
    void updateName(@Param("id") Long id, @Param("newName") String newName);
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
