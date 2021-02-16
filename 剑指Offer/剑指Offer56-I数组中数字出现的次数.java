//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
// 请写程序找出这两个只出现一次的数字。
// 要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 297 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                System.out.println(num + "添加成功");
            } else {
                map.remove(num);
                System.out.println(num + "删除成功");
            }
        }
        Set<Integer> set = map.keySet();
        int[] res = new int[2];
        if (set.size() == 2) {
            int i = 0;
            while (i < 2) {
                for (int s : set) {
                    res[i] = s;
                    System.out.println("res["+i+"]="+s+"赋值成功");
                    i++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
