package main;

import java.util.*;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                list.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}