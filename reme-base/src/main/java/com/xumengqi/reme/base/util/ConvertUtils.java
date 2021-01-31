package com.xumengqi.reme.base.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/1/31 16:45
 */
public class ConvertUtils {

    public static <O, T> List<T> toList(List<O> source, Class<T> target) {
        if (source == null || source.size() == 0) {
            return new ArrayList<>();
        }
        return source.stream().map(e -> toObj(e, target)).collect(Collectors.toList());
    }

    public static <T> T toObj(Object source, Class<T> target) {
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
