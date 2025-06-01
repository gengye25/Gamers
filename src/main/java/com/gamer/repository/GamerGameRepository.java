package com.gamer.repository;

import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GamerGameRepository extends JpaRepository<GamerGame, GamerGameID> {

}
