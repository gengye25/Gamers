package com.gamers.depository;

import com.gamers.model.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamerDepository extends JpaRepository<Gamer, String> {

    List<Gamer> findByName(String name);
}
