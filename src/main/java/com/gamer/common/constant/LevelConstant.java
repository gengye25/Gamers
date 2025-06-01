package com.gamer.common.constant;

import com.gamer.common.exception.BusinessException;

/**
 * levels in a game
 */
public class LevelConstant {

    public static final String NOOB = "N00B";
    public static final String PRO = "PRO";
    public static final String INVINCIBLE = "INVINCIBLE";

    public static final String NOOB_CODE = "1";
    public static final String PRO_CODE = "2";
    public static final String INVINCIBLE_CODE = "3";

    public static String convert(String code) {
        return switch (code) {
            case NOOB_CODE -> LevelConstant.NOOB;
            case PRO_CODE -> LevelConstant.PRO;
            case INVINCIBLE_CODE -> LevelConstant.INVINCIBLE;
            default -> throw new BusinessException(MessageConstant.INVALID_LEVEL);
        };
    }

}
