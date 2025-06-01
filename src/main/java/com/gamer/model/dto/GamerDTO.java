package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamerDTO {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Name")
    private String name;

    private String geography;

    private List<GameLevelDTO> games;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GameLevelDTO {
        private String name;
        private String levelCode;
    }

}
