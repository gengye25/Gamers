package com.gamer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GamerGameID implements Serializable {

    @Column(name = "userID")
    private Long userID;

    @Column(name = "gameID")
    private Long gameID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamerGameID that)) return false;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(gameID, that.gameID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, gameID);
    }
}
