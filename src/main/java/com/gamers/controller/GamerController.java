package com.gamers.controller;

import com.gamers.service.GamerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
@Api(tags = "api-s for gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

}
