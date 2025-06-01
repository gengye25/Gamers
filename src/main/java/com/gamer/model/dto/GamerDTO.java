package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GamerDTO {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Name")
    private String name;

    private String geography;

    private List<GameLevelDTO> games;

    @Data
    public static class GameLevelDTO {
        private String name;
        private String levelCode;
    }

}
