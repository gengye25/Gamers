package com.gamer.repository;

import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerGameRepository extends JpaRepository<GamerGame, GamerGameID> {
}
