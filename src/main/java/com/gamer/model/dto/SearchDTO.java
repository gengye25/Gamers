package com.gamer.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchDTO implements Serializable {

    private String geography;

    private String game;

    private String level;
}
