package test;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (s == sum - s - nums[i]) {
                return i;
            } else {
                s += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, -1, -1, -1, -1};
        Solution solution = new Solution();
        int s = solution.pivotIndex(nums);
        System.out.println(s);
    }
}