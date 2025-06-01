package com.gamer.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "gg_link")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GamerGame implements Serializable {

    @EmbeddedId
    private GamerGameID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    @JoinColumn(name = "userID", nullable = false)
    private Gamer gamer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameID")
    @JoinColumn(name = "gameID", nullable = false)
    private Game game;

    @Column(nullable = false)
    private String level;

}
