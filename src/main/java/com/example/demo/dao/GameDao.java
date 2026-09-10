package com.example.demo.dao;

import com.example.demo.dao.dto.GameDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameDao extends JpaRepository<GameDto, UUID> {
    Optional<GameDto> findByName(String name);
}
