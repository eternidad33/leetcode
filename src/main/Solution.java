package main;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0 || nums == null) {
            throw new RuntimeException("Error");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() < 3 ? set.last() : set.first();
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[2], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(new int[]{2, 3}));
    }
}