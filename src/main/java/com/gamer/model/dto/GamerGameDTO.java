package com.gamer.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GamerGameDTO {
    private Long userID;
    private Long gameID;
    private String level;
}
