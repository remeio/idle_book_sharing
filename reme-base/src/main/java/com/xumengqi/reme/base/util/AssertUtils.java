package com.xumengqi.reme.base.util;

import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;

/**
 * @author xumengqi
 * @date 2021/2/8 09:26
 */
public class AssertUtils {
    private AssertUtils() {

    }

    public static void isTrue(boolean val, ErrorCodeEnum errorCodeEnum, Object... args) {
        if (val) {
            return;
        }
        BizException.error(errorCodeEnum, args);
    }

    public static void isFalse(boolean val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(!val, errorCodeEnum, args);
    }

    public static void isNotNull(Object val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val != null, errorCodeEnum, args);
    }

    public static void isNull(Object val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val == null, errorCodeEnum, args);
    }

    public static void isGreaterThanZero(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val > 0, errorCodeEnum, args);
    }

    public static void isEqualZero(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val == 0, errorCodeEnum, args);
    }

    public static void isLessThanZero(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val < 0, errorCodeEnum, args);
    }

    public static void isEqualOne(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val == 1, errorCodeEnum, args);
    }

    public static void isGreaterThanOne(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val > 1, errorCodeEnum, args);
    }

    public static void isLessThanOne(long val, ErrorCodeEnum errorCodeEnum, Object... args) {
        isTrue(val < 1, errorCodeEnum, args);
    }
}
