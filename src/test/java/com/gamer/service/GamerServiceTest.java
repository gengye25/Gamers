package com.gamer.service;

import com.gamer.common.constant.MessageConstant;
import com.gamer.component.GamerGameComponent;
import com.gamer.common.exception.BusinessException;
import com.gamer.model.dto.GamerDTO;
import com.gamer.model.dto.GetGamerDTO;
import com.gamer.model.dto.SearchDTO;
import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.vo.AutoMatchGamerVO;
import com.gamer.model.vo.GetGamerTableVO;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import com.gamer.service.Impl.GamerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
    void save_successfully() {
        GamerDTO gamerDTO = new GamerDTO("Tom", null);

        Gamer savedGamer = Gamer.builder()
                .id(1L)
                .name("Tom")
                .geography("unknown")
                .build();

        when(gamerRepository.findByName("Tom")).thenReturn(Optional.empty());
        when(gamerRepository.save(any())).thenReturn(savedGamer);

        gamerServiceImpl.save(gamerDTO);

        verify(gamerRepository).save(any());
    }

    @Test
    void save_shouldThrow_userAlreadyExists(){
        GamerDTO gamerDTO = new GamerDTO("Tom", "Aarhus");

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
    void search_givenNoConditions_shouldReturnAllGamers() {
        SearchDTO dto = new SearchDTO();

        Gamer gamer = Gamer.builder()
                .id(202L)
                .name("Neo")
                .geography("Mars")
                .build();

        when(gamerRepository.findAll(Mockito.<Specification<Gamer>>any()))
                .thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Neo", result.get(0).getName());
    }

    @Test
    void search_givenOnlyGeography() {
        SearchDTO dto = new SearchDTO(null, null, "EU");

        Gamer gamer = Gamer.builder().id(1L).name("Alice").geography("EU").build();

        when(gamerRepository.findAll(ArgumentMatchers.<Specification<Gamer>>any())).thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void search_givenOnlyGame() {
        SearchDTO dto = new SearchDTO("Minecraft", null, null);

        Gamer gamer = Gamer.builder().id(2L).name("Bob").build();

        when(gamerRepository.findAll(ArgumentMatchers.<Specification<Gamer>>any())).thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Bob", result.get(0).getName());
    }

    @Test
    void search_givenOnlyLevel() {
        SearchDTO dto = new SearchDTO(null, "PRO", null);

        Gamer gamer = Gamer.builder().id(3L).name("Charlie").build();

        when(gamerRepository.findAll(ArgumentMatchers.<Specification<Gamer>>any())).thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).getName());
    }

    @Test
    void search_givenGameAndLevel() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setGame("LOL");
        searchDTO.setLevel("PRO");
        searchDTO.setGeography("CN");

        Gamer gamer = Gamer.builder()
                .id(1L)
                .name("Tom")
                .geography("CN")
                .build();

        when(gamerRepository.findAll(any(Specification.class))).thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(searchDTO);

        assertEquals(1, result.size());
        assertEquals("Tom", result.get(0).getName());

        verify(gamerRepository).findAll(any(Specification.class));
    }

    @Test
    void search_givenGeographyAndLevel() {
        SearchDTO dto = new SearchDTO(null, "INVINCIBLE", "NA");

        Gamer gamer = Gamer.builder()
                .id(101L)
                .name("Ivy")
                .geography("NA")
                .build();

        when(gamerRepository.findAll(Mockito.<Specification<Gamer>>any()))
                .thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Ivy", result.get(0).getName());
    }

    @Test
    void search_givenGeographyAndGame() {
        SearchDTO dto = new SearchDTO("Minecraft", null, "Asia");

        Gamer gamer = Gamer.builder()
                .id(102L)
                .name("Kai")
                .geography("Asia")
                .build();

        when(gamerRepository.findAll(Mockito.<Specification<Gamer>>any()))
                .thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Kai", result.get(0).getName());
    }

    @Test
    void search_givenAllConditions() {
        SearchDTO dto = new SearchDTO("LOL", "PRO", "CN");

        Gamer gamer = Gamer.builder()
                .id(201L)
                .name("Luna")
                .geography("CN")
                .build();

        when(gamerRepository.findAll(Mockito.<Specification<Gamer>>any()))
                .thenReturn(List.of(gamer));

        List<AutoMatchGamerVO> result = gamerServiceImpl.search(dto);

        assertEquals(1, result.size());
        assertEquals("Luna", result.get(0).getName());
    }

    @Test
    void getGamersTable_givenValidGameAndLevel() {
        GetGamerDTO dto = new GetGamerDTO("GTA5", "PRO");
        Gamer gamer = Gamer.builder().id(1L).name("Tom").geography("CN").build();

        when(gameRepository.findByNameIgnoreCase("GTA5"))
                .thenReturn(Optional.of(new Game()));

        when(gamerRepository.findAll(any(Specification.class)))
                .thenReturn(List.of(gamer));

        List<GetGamerTableVO> result = gamerServiceImpl.getGamersTable(dto);

        assertEquals(1, result.size());
        assertEquals("Tom", result.get(0).getName());

        verify(gameRepository).findByNameIgnoreCase("GTA5");
        verify(gamerRepository).findAll(any(Specification.class));
    }

    @Test
    void getGamersTable_gameNotExist_shouldThrowException() {
        GetGamerDTO dto = new GetGamerDTO("Random string that's not a game :P", "NOOB");

        when(gameRepository.findByNameIgnoreCase("Random string that's not a game :P")).thenReturn(Optional.empty());

        BusinessException ex = assertThrows(BusinessException.class, () -> {
            gamerServiceImpl.getGamersTable(dto);
        });

        assertEquals(MessageConstant.GAME_NOT_EXIST, ex.getMessage());

        verify(gamerRepository, never()).findAll((Example<Gamer>) any());
    }

}
