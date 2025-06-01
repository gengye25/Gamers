package com.gamer.common.component;

import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerGameDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
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
public class GamerGameComponentTest {

    @InjectMocks
    private GamerGameComponent gamerGameComponent;

    @Mock
    private GamerRepository gamerRepository;

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GamerGameRepository gamerGameRepository;

    @Test
    void bind_successfully() {
        Gamer gamer = Gamer.builder().id(1L).name("Tom").build();
        Game game = Game.builder().id(2L).name("Minecraft").build();
        GamerGameDTO gamerGameDTO = new GamerGameDTO(1L, 2L, null);

        when(gamerRepository.findById(1L)).thenReturn(Optional.of(gamer));
        when(gameRepository.findById(2L)).thenReturn(Optional.of(game));

        gamerGameComponent.bind(gamerGameDTO);

        verify(gamerGameRepository).save(any(GamerGame.class));
    }

    @Test
    void bind_shouldThrow_gamerNotExist(){
        GamerGameDTO gamerGameDTO = new GamerGameDTO(1L, 2L, "2");

        when(gamerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> gamerGameComponent.bind(gamerGameDTO));
        verify(gamerGameRepository, never()).save(any());

    }

    @Test
    void bind_shouldThrow_gameNotExist(){
        Gamer gamer = Gamer.builder().id(1L).name("Tom").build();
        GamerGameDTO gamerGameDTO = new GamerGameDTO(1L, 2L, "1");

        when(gamerRepository.findById(1L)).thenReturn(Optional.of(gamer));
        when(gameRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> gamerGameComponent.bind(gamerGameDTO));
        verify(gamerGameRepository, never()).save(any());
    }

    @Test
    void bind_shouldThrow_linkAlreadyExist(){
        Gamer gamer = Gamer.builder().id(1L).name("Tom").build();
        Game game = Game.builder().id(2L).name("Minecraft").build();
        GamerGameDTO gamerGameDTO = new GamerGameDTO(1L, 2L, "3");

        GamerGameID id = new GamerGameID(1L, 2L);
        GamerGame existingLink = new GamerGame();

        when(gamerRepository.findById(1L)).thenReturn(Optional.of(gamer));
        when(gameRepository.findById(2L)).thenReturn(Optional.of(game));
        when(gamerGameRepository.findById(id)).thenReturn(Optional.of(existingLink));

        assertThrows(BusinessException.class, () -> gamerGameComponent.bind(gamerGameDTO));
        verify(gamerGameRepository, never()).save(any());
    }
}
