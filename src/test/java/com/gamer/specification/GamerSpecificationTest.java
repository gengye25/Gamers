package com.gamer.specification;

import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import com.gamer.model.entity.GamerGameID;
import com.gamer.repository.GameRepository;
import com.gamer.repository.GamerGameRepository;
import com.gamer.repository.GamerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class GamerSpecificationTest {

    @Autowired
    private GamerRepository gamerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamerGameRepository gamerGameRepository;

    @Test
    public void testByGameAndLevel_returnsMatchingGamers() {

        Game game = gameRepository.save(Game.builder().name("LOL").build());

        Gamer gamer = gamerRepository.save(Gamer.builder()
                .name("Tom")
                .geography("Asia")
                .build());

        GamerGame gamerGame = GamerGame.builder()
                .gamer(gamer)
                .game(game)
                .level("PRO")
                .id(new GamerGameID(gamer.getId(), game.getId()))
                .build();

        gamerGameRepository.save(gamerGame);

        Specification<Gamer> spec = GamerSpecification.byGameAndLevel("LOL", "PRO");
        List<Gamer> result = gamerRepository.findAll(spec);

        assertEquals(1, result.size());
        assertEquals("Tom", result.get(0).getName());
    }

}
