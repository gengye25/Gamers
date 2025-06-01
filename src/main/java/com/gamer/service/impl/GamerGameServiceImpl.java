package com.gamer.service.impl;

import com.gamer.common.constant.LevelConstant;
import com.gamer.model.dto.GamerGameDTO;
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
    private GamerGameRepository gamerGameRepository;

    @Transactional
    public void bind(GamerGameDTO ggDTO) {
        Gamer gamer = gamerRepository.findById(ggDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("Gamer not found"));
        Game game = gameRepository.findById(ggDTO.getGameID())
                .orElseThrow(() -> new RuntimeException("Game not found"));
        String level = ggDTO.getLevel();
        if (level == null || level.trim().isEmpty()) level = LevelConstant.NOOB;
        GamerGameID id = new GamerGameID(gamer.getId(), game.getId());
        if(gamerGameRepository.findById(id).isEmpty()){
            GamerGame gamerGame = GamerGame.builder()
                    .id(id)
                    .gamer(gamer)
                    .game(game)
                    .level(level)
                    .build();
            gamerGameRepository.save(gamerGame);
            log.info("Bound gamer [{}] with game [{}] at level [{}]",
                    gamer.getName(), game.getName(), level);
        } else{
            log.info("Bound Failed. Gamer [{}] already bound to game [{}]",
                    gamer.getName(), game.getName());
        }
    }
}
