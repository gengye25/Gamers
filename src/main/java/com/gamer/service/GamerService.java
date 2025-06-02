package com.gamer.service;

import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GetGamerDTO;
import com.gamer.model.dto.SearchDTO;
import com.gamer.model.vo.AutoMatchGamerVO;
import com.gamer.model.vo.GetGamerTableVO;

import java.util.List;

public interface GamerService {

    /**
     * Create gamer
     * @param gamerDTO
     */
    void save(GamerDTO gamerDTO);

    /**
     * Search gamers by game, level and geography
     * @param searchDTO
     * @return
     */
    List<AutoMatchGamerVO> search(SearchDTO searchDTO);

    /**
     * Search gamers by game with level
     * @return
     */
    List<GetGamerTableVO> getGamersTable(GetGamerDTO getGamerDTO);
}
