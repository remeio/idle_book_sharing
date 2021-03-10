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

    public static class Builder {
        private boolean isTrue = true;

        public Builder assertTrue(boolean val) {
            isTrue = val && isTrue;
            return this;
        }

        public Builder assertFalse(boolean val) {
            return assertTrue(!val);
        }

        public Builder assertNull(Object val) {
            return assertTrue(val == null);
        }

        public Builder assertNotNull(Object val) {
            return assertTrue(val != null);
        }

        public Builder assertGreaterThanZero(long val) {
            return assertTrue(val > 0);
        }

        public Builder assertEqualZero(long val) {
            return assertTrue(val == 0);
        }

        public Builder assertLessThanZero(long val) {
            return assertTrue(val < 0);
        }

        public Builder assertEqualOne(long val) {
            return assertTrue(val == 1);
        }

        public Builder assertGreaterThanOne(long val) {
            return assertTrue(val > 1);
        }

        public Builder assertLessThanOne(long val) {
            return assertTrue(val < 1);
        }

        public Builder elseThrow(ErrorCodeEnum errorCodeEnum, Object... args) {
            if (isTrue) {
                return this;
            }
            BizException.error(errorCodeEnum, args);
            return null;
        }
    }

    public static AssertUtils.Builder asserter() {
        return new AssertUtils.Builder();
    }
}
