//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 75 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
//        //方法1：两次遍历（3ms）
//        int length = nums.length;
//        int[] res = new int[length];
//        int j = 0;
//        for (int num : nums) {
//            //先查找奇数
//            if (num % 2 == 1) {
//                res[j++] = num;
//            }
//        }
//        for (int num : nums) {
//            //再查找偶数
//            if (num % 2 != 1) {
//                res[j++] = num;
//            }
//        }
//        return res;

        //方法2：双指针(2ms)
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //可用 nums[left] & 1 判断奇偶性
            //先判断左指针是否为奇数
//            if (nums[left] % 2 == 1) {
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }

            //在判断右指针是否为偶数
//            if (nums[right] % 2 == 0) {
            if ((nums[right] & 1) == 0) {
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
