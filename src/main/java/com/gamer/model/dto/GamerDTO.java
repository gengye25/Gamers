package com.gamer.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GamerDTO {

    private String name;

    private String geography;

    private List<GameLevelDTO> games;

    @Data
    public static class GameLevelDTO {
        private String name;
        private String level;
    }

}
