//找出数组中重复的数字。 
//
// 
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
// 数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表 
// 👍 244 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
//        //方法1：先排序，比较和之前相同的情况返回(3ms)
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return nums[i];
//            }
//        }
//        return -1;

//        //方法2：哈希表法（5ms）
//        Set<Integer> set = new HashSet<>();
//        int result = -1;
//        for (int num : nums) {
//            // 数组元素不能加入哈希表，跳出循环并返回结果
//            if (!set.add(num)) {
//                result = num;
//                break;
//            }
//        }
//        return result;

        //方法3：原地置换(0ms)
        // 注意：nums里的所有数字都在 0～n-1 的范围内
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //若是nums[i]一直不相等，就一直置换
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
