package com.gamer.controller;

import com.gamer.common.result.Result;
import com.gamer.model.dto.GamerDTO;
import com.gamer.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gamer")
@Slf4j
@Tag(name = "api-s for gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    /**
     * saveing new gamers (with the game)
     * @param gamerdto
     */
    @PostMapping
    @Operation(summary = "Create a new gamer")
    public Result save(@RequestBody GamerDTO gamerdto) {
        log.info("New gamer: {}", gamerdto);
        gamerService.save(gamerdto);
        return Result.success();
    }


}
