package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/01/24
 */
public class 满足三条件之一需改变的最少字符数 {
    public int minCharacters(String a, String b) {
        char minA = 'z', minB = 'z';
        int countA = 1, countB = 1;
        findMinCount(a, minA, countA);
        findMinCount(b, minB, countB);
        return 0;
    }

    public void findMinCount(String s, char min, int count) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
                count = 1;
            }
            if (s.charAt(i) == min) {
                count++;
            }
        }
    }
}
