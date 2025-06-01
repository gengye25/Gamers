package com.gamer.controller;

import com.gamer.common.result.Result;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.service.GamerGameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gamer_game")
@Slf4j
@Tag(name = "gamer_game")
public class GamerGameController {

    @Autowired
    GamerGameService gamerGameService;

    /**
     * bind gamer to a game
     * @param ggDTO
     * @return
     */
    @PostMapping
    @Operation(summary = "New gamer-game binding")
    public Result link(@RequestBody @Valid GamerGameDTO ggDTO) {
        log.info("Bind gamer to game: {}", ggDTO);
        gamerGameService.bind(ggDTO);
        return Result.success("Linked successfully");
    }

}
