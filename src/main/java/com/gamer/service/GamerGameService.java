package com.gamer.service;

import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.dto.GamerGameLinkDTO;
import com.gamer.model.entity.GamerGame;

import java.util.Optional;

public interface GamerGameService {

    void bindByName(GamerGameLinkDTO gamerGameLinkDTO);

    //TODO
    GamerDTO findGamer();

}
