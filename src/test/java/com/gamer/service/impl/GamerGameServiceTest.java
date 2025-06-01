package com.gamer.service.impl;


import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerGameService;
import com.gamer.service.GamerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GamerGameServiceTest {

    @InjectMocks
    private GamerGameServiceImpl gamerGameServiceImpl;

    @Mock
    private GamerService gamerService;

    @Mock
    private GamerGameService gamerGameService;

    @Mock
    private GamerRepository gamerRepository;

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GamerGameRepository gamerGameRepository;

    @Test
    void bind_userIDWithGameID(){

    }

    @Test
    void bind_userIDWithGameIDWithLevel(){

    }

}
