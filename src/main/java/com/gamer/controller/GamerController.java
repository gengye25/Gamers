package com.gamer.controller;

import com.gamer.common.constant.LevelConstant;
import com.gamer.common.result.Result;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GetGamerDTO;
import com.gamer.model.dto.SearchDTO;
import com.gamer.model.entity.Gamer;
import com.gamer.model.vo.AutoMatchGamerVO;
import com.gamer.model.vo.GetGamerTableVO;
import com.gamer.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamer")
@Slf4j
@Tag(name = "gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    /**
     * Create a new gamer
     * @param gamerDTO
     */
    @PostMapping
    @Operation(summary = "Create a new gamer")
    public Result save(@RequestBody @Valid GamerDTO gamerDTO) {
        log.info("New gamer: {}", gamerDTO);
        gamerService.save(gamerDTO);
        return Result.success("Gamer Created");
    }

    /**
     * Search gamers
     * @param game
     * @param levelCode
     * @param geography
     * @return
     */
    @GetMapping(("/search"))
    @Operation(summary = "Search gamers by game, level and geography")
    public Result<List<AutoMatchGamerVO>> search(
            @RequestParam(required = false) String game,
            @RequestParam(required = false) String levelCode,
            @RequestParam(required = false) String geography
    ) {
        String level = LevelConstant.convert(levelCode);
        if(levelCode == null || levelCode.isBlank()) level = null;
        log.info("Search gamer with: game={}, level={}, geo={}", game, level, geography);
        SearchDTO searchDTO = SearchDTO.builder()
                .geography(geography)
                .game(game)
                .level(level)
                .build();
        log.info("SearchDTO game =  [{}], level = [{}], geo = [{}]", searchDTO.getGame(), searchDTO.getLevel(), searchDTO.getGeography());
        List<AutoMatchGamerVO> gamersAutoMatched = gamerService.search(searchDTO);
        log.info("Matched gamers: {}", gamersAutoMatched);
        return Result.<List<AutoMatchGamerVO>>success(gamersAutoMatched);
    }

    /**
     * Get gamers by game and level
     * @param game
     * @param levelCode
     * @return
     */
    @GetMapping(("/get_by_game_and_level"))
    @Operation(summary = "Get gamers by game and level")
    public Result<List<GetGamerTableVO>> getGamerTable(
            @RequestParam(required = true) String game,
            @RequestParam(required = true) String levelCode
    ){
        String level = LevelConstant.convert(levelCode);
        log.info("Search gamer with: game={}, level={}", game, level);
        GetGamerDTO getGamerDTO = new GetGamerDTO(game, level);
        List<GetGamerTableVO> gamersTable = gamerService.getGamersTable(getGamerDTO);
        return Result.<List<GetGamerTableVO>>success(gamersTable);
    }



}
