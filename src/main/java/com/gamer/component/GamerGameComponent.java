package com.gamer.component;

import com.gamer.common.constant.LevelConstant;
import com.gamer.common.constant.MessageConstant;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GamerGameComponent {

    @Autowired
    private GamerRepository gamerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamerGameRepository gamerGameRepository;

    @Transactional
    public void bind(GamerGameDTO ggDTO) {
        Gamer gamer = gamerRepository.findById(ggDTO.getUserID())
                .orElseThrow(() -> new BusinessException(MessageConstant.USER_NOT_EXIST));
        Game game = gameRepository.findById(ggDTO.getGameID())
                .orElseThrow(() -> new BusinessException(MessageConstant.GAME_NOT_EXIST));
        String level = LevelConstant.convert(ggDTO.getLevelCode());
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
            throw new BusinessException(MessageConstant.LINK_ALREADY_EXIST);
        }
    }
}
