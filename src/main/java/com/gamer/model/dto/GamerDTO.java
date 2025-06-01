package com.gamer.model.dto;

import com.gamer.common.constant.MessageConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamerDTO implements Serializable {

    @NotBlank(message = MessageConstant.FIELD_NOT_BLANK + "Name")
    private String name;

    private String geography;

}
