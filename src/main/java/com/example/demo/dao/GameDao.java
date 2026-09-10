package com.example.demo.dao;

import com.example.demo.dao.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameDao extends JpaRepository<GameEntity, Long> {
    Optional<GameEntity> findByName(String name);
}
