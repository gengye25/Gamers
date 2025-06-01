package com.gamer.common.constant;

import com.gamer.common.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelConstantTest {

    @Test
    void convert_codeToName() {
        assertEquals(LevelConstant.NOOB, LevelConstant.convert("1"));
        assertEquals(LevelConstant.PRO, LevelConstant.convert("2"));
        assertEquals(LevelConstant.INVINCIBLE, LevelConstant.convert("3"));
    }

    @Test
    void convert_blankToDefaultCode(){
        assertEquals(LevelConstant.NOOB, LevelConstant.convert(null));
        assertEquals(LevelConstant.NOOB, LevelConstant.convert(""));
        assertEquals(LevelConstant.NOOB, LevelConstant.convert(" "));
    }

    @Test
    void convert_shouldThrow_InvalidCode() {
        assertThrows(BusinessException.class, () -> LevelConstant.convert("0"));
        assertThrows(BusinessException.class, () -> LevelConstant.convert("random string"));
    }
}
