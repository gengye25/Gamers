package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GamerGameDTO implements Serializable {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Gamer's name")
    private Long userID;

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Game")
    private Long gameID;

    private String levelCode;
}
