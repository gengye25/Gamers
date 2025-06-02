package com.gamer.service;

import com.gamer.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.dto.GamerGameLinkDTO;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.Impl.GamerGameServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Mock
    private GamerGameComponent gamerGameComponent;

    @Test
    void bindByName_successfully(){
        GamerGameLinkDTO gamerGameLinkDTO = new GamerGameLinkDTO("Tom", "Minecraft", "3");

        when(gamerRepository.findIdByName("Tom")).thenReturn(Optional.of(1L));
        when(gameRepository.findIdByName("Minecraft")).thenReturn(Optional.of(2L));

        gamerGameServiceImpl.bindByName(gamerGameLinkDTO);

        verify(gamerGameComponent).bind(any(GamerGameDTO.class));
    }

    @Test
    void bindByName_userNotExist(){
        GamerGameLinkDTO gamerGameLinkDTO = new GamerGameLinkDTO("Tom", "Minecraft", null);

        when(gamerRepository.findIdByName("Tom")).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> gamerGameServiceImpl.bindByName(gamerGameLinkDTO));
        verify(gameRepository, org.mockito.Mockito.never()).findIdByName(any());
        verify(gamerGameComponent, org.mockito.Mockito.never()).bind(any());
    }

    @Test
    void bindByName_gameNotExist(){
        GamerGameLinkDTO gamerGameLinkDTO = new GamerGameLinkDTO("Tom", "Minecraft", null);

        when(gamerRepository.findIdByName("Tom")).thenReturn(Optional.of(1L));
        when(gameRepository.findIdByName("Minecraft")).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> gamerGameServiceImpl.bindByName(gamerGameLinkDTO));
        verify(gamerGameComponent, org.mockito.Mockito.never()).bind(any());
    }

}
