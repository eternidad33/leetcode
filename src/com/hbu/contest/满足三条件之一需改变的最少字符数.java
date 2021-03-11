package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/01/24
 */
public class 满足三条件之一需改变的最少字符数 {
    public int minCharacters(String a, String b) {
        int[] acnt = new int[26];
        int[] bcnt = new int[26];
        int an = a.length(), bn = b.length();

        for (int i = 0; i < an; i++) {
            char c = a.charAt(i);
            acnt[c - 'a']++;
        }
        for (int i = 0; i < bn; i++) {
            char c = b.charAt(i);
            bcnt[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE, asum = 0, bsum = 0;
        for (int i = 0; i < 25; i++) {
            asum += acnt[i];
            bsum += bcnt[i];
            ans = Math.min(Math.min(ans, an - acnt[i] + bn - bcnt[i]), Math.min(an - asum + bsum, bn - bsum + asum));
        }
        ans = Math.min(ans, an - acnt[25] + bn - bcnt[25]);

        return ans;
    }
}
