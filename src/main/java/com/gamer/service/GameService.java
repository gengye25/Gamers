package com.gamer.service;

import com.gamer.model.dto.GameDTO;

public interface GameService {

    /**
     * Create a game
     * @param gameDTO
     */
    void save(GameDTO gameDTO);

}
