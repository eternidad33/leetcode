//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 110 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //方法1：哈希表法
        int m = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count;
            //哈希表不包含num
            if (!map.containsKey(num)) {
                count = 1;
            } else {
                count = map.get(num) + 1;
            }
            if (count > m) {
                return num;
            }
            map.put(num, count);
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
