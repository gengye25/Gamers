package com.gamer.service.Impl;

import com.gamer.common.constant.GeographyConstant;
import com.gamer.common.constant.MessageConstant;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GameDTO;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.repository.GameRepository;
import com.gamer.service.GameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Transactional
    public void save(GameDTO gameDTO){

        if (gameRepository.findByName(gameDTO.getName()).isPresent()) { // New gamer
            throw new BusinessException(MessageConstant.GAME_ALREADY_EXIST + gameDTO.getName());
        }

        Game game = Game.builder()
                .name(gameDTO.getName())
                .build();
        game = gameRepository.save(game);
        log.info("Game [{}] created", game.getName());

    }

}
