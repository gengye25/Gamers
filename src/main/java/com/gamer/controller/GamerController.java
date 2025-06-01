package com.gamer.controller;

import com.gamer.common.result.Result;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.entity.Gamer;
import com.gamer.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gamer")
@Slf4j
@Tag(name = "gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    /**
     * saveing new gamers (with the game)
     * @param gamerDTO
     */
    @PostMapping
    @Operation(summary = "Create a new gamer")
    public Result save(@RequestBody @Valid GamerDTO gamerDTO) {
        log.info("New gamer: {}", gamerDTO);
        gamerService.save(gamerDTO);
        return Result.success("Gamer Created");
    }


}
