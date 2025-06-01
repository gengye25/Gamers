package com.gamer.service.impl;

import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerGameService;
import com.gamer.service.GamerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class GamerServiceImpl implements GamerService {

    private final GamerRepository gamerRepository;
    private final GameRepository gameRepository;
    private final GamerGameRepository gamerGameRepository;
    private final GamerGameService gamerGameService;

    @Transactional
    public void save(GamerDTO gamerDTO){
        if (gamerRepository.findByName(gamerDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("Gamer with name [" + gamerDTO.getName() + "] already exists.");
        }

        Gamer gamer = Gamer.builder()
                .name(gamerDTO.getName())
                .geography(gamerDTO.getGeography())
                .build();
        gamer = gamerRepository.save(gamer);
        log.info("Gamer [{}] created", gamer.getName());

        if(gamerDTO.getGames() != null && !gamerDTO.getGames().isEmpty()){
            Map<String, Game> gameCache = new HashMap<>();
            for(GamerDTO.GameLevelDTO g : gamerDTO.getGames()){
                if (g.getName() == null || g.getName().isBlank()) {
                    throw new IllegalArgumentException("Game name cannot be empty");
                }

                Game game = gameCache.computeIfAbsent(g.getName(), name -> gameRepository.findByName(name)
                        .orElseGet(() -> gameRepository.save(new Game(null, g.getName(), null))));

                GamerGameDTO ggDTO = GamerGameDTO.builder()
                        .userID(gamer.getId())
                        .gameID(game.getId())
                        .level(g.getLevel())
                        .build();

                gamerGameService.bind(ggDTO);
            }

        }

    }

}
