package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GamerGameLinkDTO implements Serializable {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Gamer's name")
    private String user;

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Game")
    private String game;

    private String levelCode;
}
