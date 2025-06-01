package com.gamer.service.impl;

import com.gamer.common.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.entity.Gamer;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GamerServiceTest {

    @InjectMocks
    private GamerServiceImpl gamerServiceImpl;

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

    @Mock
    private GamerGameComponent gamerGameComponent;


    @Test
    void save_createUserOnly(){
        GamerDTO gamerDTO = new GamerDTO("Tom", null, null);

        Gamer savedGamer = Gamer.builder()
                .id(1L)
                .name("Tom")
                .geography("unknown")
                .build();

        when(gamerRepository.findByName("Tom")).thenReturn(Optional.empty());
        when(gamerRepository.save(any())).thenReturn(savedGamer);

        gamerServiceImpl.save(gamerDTO);

        verify(gamerRepository).save(any());
        verify(gamerGameComponent, never()).bind(any());
    }

    @Test
    void save_shouldThrow_userAlreadyExists(){
        GamerDTO gamerDTO = new GamerDTO("Tom", "Aarhus", null);

        Gamer existingGamer = Gamer.builder()
                .id(1L)
                .name("Tom")
                .geography("Aarhus")
                .build();


        when(gamerRepository.findByName("Tom")).thenReturn(Optional.of(existingGamer));
        assertThrows(BusinessException.class, () -> gamerServiceImpl.save(gamerDTO));
        verify(gamerRepository, never()).save(any());
    }

    @Test
    void save_createUserAndLinkWithAGame(){

    }



}
