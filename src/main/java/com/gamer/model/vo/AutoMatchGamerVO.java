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
@Getter
@Setter
public class AutoMatchGamerVO implements Serializable {

    private String name;

    public static AutoMatchGamerVO fromEntity(Gamer gamer) {
        if (gamer == null) return null;

        AutoMatchGamerVO vo = new AutoMatchGamerVO();
        vo.name = gamer.getName();
        return vo;
    }
}
