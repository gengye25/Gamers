package com.gamer.specification;

import com.gamer.model.entity.Game;
import com.gamer.model.entity.Gamer;
import com.gamer.model.entity.GamerGame;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class GamerSpecification {

    public static Specification<Gamer> byGameAndLevel(String game, String level) {
        return (root, query, cb) -> {
            Join<Gamer, GamerGame> gamerGameJoin = root.join("gamerGames", JoinType.INNER);

            List<Predicate> predicates = new ArrayList<>();
            if (game != null && !game.isBlank()) {
                Join<GamerGame, Game> gameJoin = gamerGameJoin.join("game", JoinType.INNER);
                predicates.add(cb.equal(gameJoin.get("name"), game));
            }
            if (level != null && !level.isBlank()) {
                predicates.add(cb.equal(gamerGameJoin.get("level"), level));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
