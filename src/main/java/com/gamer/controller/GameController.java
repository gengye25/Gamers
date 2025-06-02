package com.gamer.controller;

import com.gamer.common.result.Result;
import com.gamer.model.dto.GameDTO;
import com.gamer.model.dto.GamerDTO;
import com.gamer.service.GameService;
import com.gamer.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@Slf4j
@Tag(name = "game")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Create a game
     * @param gameDTO
     */
    @PostMapping
    @Operation(summary = "Create a new game")
    public Result save(@RequestBody @Valid GameDTO gameDTO) {
        log.info("New game: {}", gameDTO);
        gameService.save(gameDTO);
        return Result.success("Game Created");
    }
}
