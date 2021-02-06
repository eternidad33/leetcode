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
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Math.abs(nums[0]);
        System.out.print(dp[0] + " ");
        for (int i = 1; i < nums.length; i++) {
            //计算当前值与前一个dp的和
            int a = nums[i] + dp[i - 1];
            int b = nums[i];
            dp[i] = Math.abs(a) > Math.abs(b) ? a : b;
            if (nums[i - 1] > 0 && nums[i] > 0) {
                int c = nums[i - 1] + nums[i];
                dp[i] = Math.abs(dp[i]) > Math.abs(c) ? dp[i] : c;
            }
            if (nums[i - 1] < 0 && nums[i] < 0) {
                int c = nums[i - 1] + nums[i];
                dp[i] = Math.abs(dp[i]) > Math.abs(c) ? dp[i] : c;
            }

            res = Math.max(res, Math.abs(dp[i]));
            System.out.print(dp[i] + "\t");
        }
        System.out.println();
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
