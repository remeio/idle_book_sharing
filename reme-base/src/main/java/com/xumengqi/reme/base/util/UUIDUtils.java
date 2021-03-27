package com.xumengqi.reme.base.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/27 14:06
 */
public class UUIDUtils {
    private UUIDUtils() {
        throw new IllegalArgumentException();
    }

    public static String getOrderNo() {
        return getOrderNo(8);
    }

    public static String getOrderNo(int num) {
        String time = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        String randomString = RandomStringUtils.randomNumeric(num);
        return time + randomString;
    }
}
