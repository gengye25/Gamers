package com.gamer.service.Impl;

import com.gamer.common.constant.MessageConstant;
import com.gamer.common.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.dto.GamerGameLinkDTO;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
