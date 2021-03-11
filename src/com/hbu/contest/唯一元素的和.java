package com.hbu.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author vigilr
 * @since 2021/02/06
 */
public class 唯一元素的和 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count;
            if (!map.containsKey(num)) {
                count = 1;
            } else {
                count = map.get(num) + 1;
            }
            map.put(num, count);
        }
        int sum = 0;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }
}
