package com.gamer.service;

import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.SearchDTO;
import com.gamer.model.vo.AutoMatchGamerVO;

import java.util.List;

public interface GamerService {

    /**
     * Link gamer to game
     * @param gamerDTO
     */
    void save(GamerDTO gamerDTO);

    List<AutoMatchGamerVO> search(SearchDTO searchDTO);

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
