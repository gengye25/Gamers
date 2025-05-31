package com.gamer.service;

import com.gamer.model.dto.GamerDTO;

public interface GamerService {

    /**
     * Link gamer to game
     * @param gamerDTO
     */
    void save(GamerDTO gamerDTO);

    /**
     * Update gamer
     * @param gamerDTO
     */
//    void update(GamerDTO gamerDTO);
//
//    /**
//     * query based on level, game and geography
//     * @param gamerDTO
//     * @return
//     */
//    Gamer findGamer(GamerDTO gamerDTO);
}
