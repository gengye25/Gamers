package com.gamer.model.dto;

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

    @NotBlank()
    private String game;

    private String level;
}
