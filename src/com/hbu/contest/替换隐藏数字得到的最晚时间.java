package com.hbu.contest;

import java.util.ArrayList;

/**
 * @author vigilr
 * @since 2021/01/24
 */
public class 替换隐藏数字得到的最晚时间 {
    public String maximumTime(String time) {
        StringBuffer sb = new StringBuffer();
        //？在第1个位置和第2个位置
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            sb.append("23");
        }
        //第1个位置
        if (time.charAt(0) == '?' && time.charAt(1) != '?') {
            if (time.charAt(1) > '3' && time.charAt(1) <= '9') {
                sb.append('1');
            } else {
                sb.append('2');
            }
            sb.append(time.charAt(1));
        }
        //第2个位置为？
        if (time.charAt(0) != '?' && time.charAt(1) == '?') {
            sb.append(time.charAt(0));
            if (time.charAt(0) == '0' || time.charAt(0) == '1') {
                sb.append('9');
            }
            if (time.charAt(0) == '2') {
                sb.append('3');
            }
        }
        //前两个位置全不为‘?'
        if (time.charAt(0) != '?' && time.charAt(1) != '?') {
            sb.append(time.charAt(0));
            sb.append(time.charAt(1));
        }
        //第3,4个位置：
        sb.append(':');
        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            sb.append("59");
        }
        //3
        if (time.charAt(3) == '?' && time.charAt(4) != '?') {
            sb.append('5');
            sb.append(time.charAt(4));
        }
        //4
        if (time.charAt(3) != '?' && time.charAt(4) == '?') {
            sb.append(time.charAt(3));
            sb.append('9');
        }
        //后两个位置全不为‘?'
        if (time.charAt(3) != '?' && time.charAt(4) != '?') {
            sb.append(time.charAt(3));
            sb.append(time.charAt(4));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
