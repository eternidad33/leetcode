package com.hbu.nk;

import java.util.Scanner;

/**
 * @author vigilr
 * @since 2021/02/22
 */
public class 大数加法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int a = Integer.parseInt(s1.substring(1,s1.length()-1));
        int b = Integer.parseInt(s2.substring(1,s2.length()-1));
        System.out.println("\"" + (a + b) + "\"");
    }
}
