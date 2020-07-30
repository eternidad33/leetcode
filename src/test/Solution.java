package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

    }
}