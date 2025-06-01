package com.gamer.repository;

import com.gamer.model.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GamerRepository extends JpaRepository<Gamer, Long> {
    Optional<Gamer> findByName(String name);
}
