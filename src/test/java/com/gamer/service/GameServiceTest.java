package com.gamer.service;

import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GameDTO;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.Impl.GameServiceImpl;
import com.gamer.service.Impl.GamerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @InjectMocks
    private GameServiceImpl gameServiceImpl;

    @Mock
    private GameRepository gameRepository;


    @Test
    void save_successfully() {
        GameDTO gameDTO = new GameDTO("RandomGame");

        Game savedGame= Game.builder()
                .id(1L)
                .name("RandomGame")
                .build();

        when(gameRepository.findByName("RandomGame")).thenReturn(Optional.empty());
        when(gameRepository.save(any())).thenReturn(savedGame);

        gameServiceImpl.save(gameDTO);

        verify(gameRepository).save(any());
    }

    @Test
    void save_shouldThrown_gameAlreadyExist() {
        GameDTO gameDTO = new GameDTO("RandomGame");

        Game existingGame= Game.builder()
                .id(1L)
                .name("RandomGame")
                .build();

        when(gameRepository.findByName("RandomGame")).thenReturn(Optional.of(existingGame));

        assertThrows(BusinessException.class, () -> gameServiceImpl.save(gameDTO));
        verify(gameRepository, never()).save(any());
    }
}
