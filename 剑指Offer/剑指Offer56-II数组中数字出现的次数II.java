//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
// 请找出那个只出现一次的数字。
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i] != nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
