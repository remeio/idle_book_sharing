package com.xumengqi.reme.as.util;

import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/4/2 13:14
 */
@Component
public class IsbnUtils {
    public static boolean isValidIsbn(String isbn) {
        try {
            return checkIsbn(isbn);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkIsbn(String isbn) {
        int count = 0;
        int checkBitInt = 0;
        char[] cs = isbn.toCharArray();
        switch (isbn.length()) {
            case 10:
                for (int i = 0; i < 9; i++) {
                    if (cs[i] < '0' || cs[i] > '9') {
                        throw new IllegalArgumentException("ISBN " + isbn +
                                " 第 " + (i + 1) + " 位中出现非法字符 " + cs[i]);
                    }
                    int c = cs[i] - '0';
                    count += c * (10 - i);
                }
                if (cs[9] >= '0' && cs[9] <= '9') {
                    checkBitInt = cs[9] - '0';
                } else if (cs[9] == 'X' || cs[9] == 'x') {
                    checkBitInt = 10;
                } else {
                    throw new IllegalArgumentException("ISBN " + isbn +
                            " 第 10 位中出现非法字符 " + cs[9]);
                }
                return (count + checkBitInt) % 11 == 0;
            case 13:
                if (!isbn.startsWith("978") && !isbn.startsWith("979")) {
                    throw new IllegalArgumentException("ISBN-13 格式不符合标准");
                }
                int countEven = 0;
                int countOdd = 0;
                for (int i = 0; i < 12; i++) {
                    int c = cs[i] - '0';
                    if (c < 0 || c > 9) {
                        throw new IllegalArgumentException("ISBN " + isbn +
                                " 第 " + (i + 1) + " 位中出现非法字符 " + cs[i]);
                    }
                    if ((i & 0x1) == 0) {
                        countOdd += c;
                    } else {
                        countEven += c;
                    }
                }
                count = countOdd + (countEven * 3);
                if (cs[12] < '0' || cs[12] > '9') {
                    throw new IllegalArgumentException("ISBN " + isbn
                            + " 第 13 位中出现非法字符 " + cs[12]);
                }

                checkBitInt = cs[12] - '0';
                return (count + checkBitInt) % 10 == 0;
            default:
                // ISBN为非10位或13位时抛出异常
                throw new IllegalArgumentException("ISBN 格式不符合标准");
        }
    }
}
