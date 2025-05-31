package com.gamers.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gamer")
public class Gamer implements Serializable {

    @Id
    private Long id;

    private String name;

    private String geography;

    private String game;

    @Column(nullable = false)
    private String level;

}
