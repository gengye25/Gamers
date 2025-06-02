package com.gamer.repository;

import com.gamer.model.entity.Game;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByName(String name);

    @Query("select g.id FROM Game g WHERE g.name = :name")
    Optional<Long> findIdByName(@Param("name") String name);

    Optional<Game> findByNameIgnoreCase(String name);

}
