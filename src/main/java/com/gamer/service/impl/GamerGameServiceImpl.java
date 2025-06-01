package com.gamer.service.impl;

import com.gamer.common.LevelConstant;
import com.gamer.common.MessageConstant;
import com.gamer.common.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.dto.GamerGameLinkDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerGameService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GamerGameServiceImpl implements GamerGameService {

    @Autowired
    private GamerRepository gamerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamerGameComponent gamerGameComponent;

    /**
     * binding an exist gamer to an exist game by name
     * @param gamerGameLinkDTO
     */
    public void bindByName(GamerGameLinkDTO gamerGameLinkDTO) {
        Long userID = gamerRepository.findIdByName(gamerGameLinkDTO.getUser())
                .orElseThrow(() -> new BusinessException(MessageConstant.USER_NOT_EXIST));
        Long gameID = gameRepository.findIdByName(gamerGameLinkDTO.getGame())
                .orElseThrow(() -> new BusinessException(MessageConstant.GAME_NOT_EXIST));
        GamerGameDTO gamerGameDTO = GamerGameDTO.builder()
                .userID(userID)
                .gameID(gameID)
                .levelCode(gamerGameLinkDTO.getLevelCode())
                .build();
        gamerGameComponent.bind(gamerGameDTO);
    }

    @Override
    public GamerDTO findGamer() {
        return null;
    }
}
