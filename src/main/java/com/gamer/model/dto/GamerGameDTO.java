package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GamerGameDTO {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Gamer's name")
    private Long userID;

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Game")
    private Long gameID;

    private String levelCode;
}
