package com.gamer.model.vo;

import com.gamer.model.entity.Gamer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetGamerTableVO implements Serializable {

    private String name;

    private String geography;

    public GetGamerTableVO(Gamer gamer) {
        this.name = gamer.getName();
        this.geography = gamer.getGeography();
    }
}
