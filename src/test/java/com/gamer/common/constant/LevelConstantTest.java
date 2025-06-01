package com.gamer.common.constant;

import com.gamer.common.LevelConstant;
import com.gamer.common.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelConstantTest {

    @Test
    void convert_shouldReturnCorrectLevelName_forValidCodes() {
        assertEquals(LevelConstant.NOOB, LevelConstant.convert("1"));
        assertEquals(LevelConstant.PRO, LevelConstant.convert("2"));
        assertEquals(LevelConstant.INVINCIBLE, LevelConstant.convert("3"));
    }

    @Test
    void convert_shouldThrowBusinessException_forInvalidCode() {
        assertThrows(BusinessException.class, () -> LevelConstant.convert("4"));
        assertThrows(BusinessException.class, () -> LevelConstant.convert("0"));
        assertThrows(BusinessException.class, () -> LevelConstant.convert(null));
        assertThrows(BusinessException.class, () -> LevelConstant.convert(""));
    }
}
