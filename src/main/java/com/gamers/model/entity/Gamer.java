package com.gamers.model.entity;

import jakarta.persistence.Id;
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

    @Id
    private Long userId;

    private String geography;

    private String game;

    private String level;

}
