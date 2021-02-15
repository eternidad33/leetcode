//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 156 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        //快速排序
        //将int数组转为String数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        //排序
        fastSort(strs, 0, strs.length - 1);

        //拼接
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }

    /**
     * 快速排序
     *
     * @param strs  字符串数组
     * @param left  开始位置
     * @param right 结束位置
     */
    public void fastSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String temp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) {
                i++;
            }
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[left];
        strs[left] = temp;
        fastSort(strs, left, i - 1);
        fastSort(strs, i + 1, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
