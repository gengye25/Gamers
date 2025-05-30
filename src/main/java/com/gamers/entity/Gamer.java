package com.gamers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gamer implements Serializable {
    private String name;

    private String geography;

    private String game;

    private String level;

}
