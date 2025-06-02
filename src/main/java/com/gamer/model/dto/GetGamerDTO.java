package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetGamerDTO implements Serializable {

    @NotBlank(message = MessageConstant.CONDITION_MISSING + "game")
    private String game;

    @NotBlank(message = MessageConstant.CONDITION_MISSING + "level")
    private String level;
}
