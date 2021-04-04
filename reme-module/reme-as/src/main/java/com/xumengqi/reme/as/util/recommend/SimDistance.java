package com.xumengqi.reme.as.util.recommend;

import java.util.Objects;

/**
 * @author xumengqi
 * @date 2021/4/3 16:20
 */
public class SimDistance {
    public static double getSimDistance(double[] vector1, double[] vector2) {
        Objects.requireNonNull(vector1);
        Objects.requireNonNull(vector2);
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("not the same length for vector 1 and vector 2");
        }
        if (vector1.length == 0) {
            throw new IllegalArgumentException("empty vector");
        }
        double sum = 0;
        for (int i = 0; i < vector1.length; i++) {
            double v1 = vector1[i];
            double v2 = vector2[i];
            sum += Math.pow(v1 - v2, 2);
        }
        return Math.sqrt(sum);
    }
}
