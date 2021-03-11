package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/02/06
 */
public class 任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = 0, min = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            max = max >= 0 ? max + nums[i] : nums[i];
            min = min <= 0 ? min + nums[i] : nums[i];
            res = Math.max(res, Math.abs(max));
            res = Math.max(res, Math.abs(min));
        }
        return res;
    }

    public static void main(String[] args) {
        任意子数组和的绝对值的最大值 test = new 任意子数组和的绝对值的最大值();
//        int[] nums = {-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        int[] nums = {-3, -5, -3, -2, -6, 3, 10, -10, -8, -3, 0, 10, 3, -5, 8, 7, -9, -9, 5, -8};
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
        int s = test.maxAbsoluteSum(nums);
        System.out.println(s);
    }
}
