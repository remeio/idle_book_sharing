package com.xumengqi.reme.base.util;

import org.springframework.beans.BeanUtils;

/**
 * @author xumengqi
 * @date 2021/1/31 16:45
 */
public class ConvertUtils {

    public static <T> T convertTo(Object source, Class<T> target) {
        try {
            T targetInstance = target.newInstance();
            copyProperties(source, targetInstance);
            return targetInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("convert error.");
        }
    }

    public static <T> void copyProperties(Object source, T target) {
        BeanUtils.copyProperties(source, target);
    }
}
