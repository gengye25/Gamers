package com.gamer.controller;

import com.gamer.common.result.Result;
import com.gamer.model.dto.GamerDTO;
import com.gamer.service.GamerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
@Api(tags = "api-s for gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    /**
     * saveing new gamers (with the game)
     * @param gamerdto
     */
    @PostMapping
    @ApiOperation("New gamer")
    public Result save(@RequestBody GamerDTO gamerdto) {
        log.info("New gamer: {}", gamerdto);
        gamerService.save(gamerdto);
        return Result.success();
    }


}
