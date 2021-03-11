package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/02/14
 */
public class 生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '0' && chars[i] == '0') {
                chars[i] = '1';
                count++;
            } else if (chars[i - 1] == '1' && chars[i] == '1') {
                chars[i] = '0';
                count++;
            }
        }
        count = Math.min(count, chars.length - count);
        return count;
    }
}
