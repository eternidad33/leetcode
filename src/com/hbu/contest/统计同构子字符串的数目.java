package com.hbu.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vigilr
 * @since 2021/02/14
 */
public class 统计同构子字符串的数目 {
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        if (chars == null || chars.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        long res = 1;
        //双指针法
        int start = 0, end = 1;
        while (end < chars.length) {
            if (chars[end] != chars[end - 1]) {
                // 截断字符串，存为temp
                String temp = s.substring(start, end);

                // 判断哈希表是否存在temp
                if (!map.containsKey(temp)) {
                    // 不存在，存（temp，1）
                    map.put(temp, 1);
                } else {
                    // 存在,存（temp,count+1）
                    int count = map.get(temp);
                    map.put(temp, count + 1);
                }


                //更新start
                start = end;
            }
            end++;
        }
        //遍历哈希表
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            //获取子字符串是否在hashmap
            int l=key.length();
            System.out.println(key + "：" + value);
            res += value * f(key);
        }
        return (int) res % 1000000007;
    }

    public long f(String s) {
        int l = s.length();
        long sum = 0;
        for (int i = 1; i <= l; i++) {
            sum += i;
        }
        return sum;
    }
}
