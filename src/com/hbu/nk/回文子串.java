package com.hbu.nk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author vigilr
 * @since 2021/02/22
 */
public class 回文子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                list.add(s.substring(i,j+1));
            }
        }
        int cnt = 0;
        for(String temp : list) {
            if(isPalindrome(temp)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static boolean isPalindrome(String s) {
        if(s.length() ==  1) {
            return true;
        }

        StringBuilder sb = new StringBuilder(s);

        return sb.toString().equals(sb.reverse().toString());
    }
}
