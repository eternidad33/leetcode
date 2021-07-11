//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1000 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        // 开辟新数组
        int[] sorted = new int[m + n];

        // 移动双指针
        while (i < m || j < n) {
            int curr;
            // nums1或nums2到头
            if (i == m) {
                curr = nums2[j++];
            } else if (j == n) {
                curr = nums1[i++];
                // nums1和nums2中的数比较大小
            } else if (nums1[i] < nums2[j]) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
            sorted[i + j - 1] = curr;
        }

        // 将新数组的元素存入nums1
        for (int k = 0; k < (m + n); k++) {
            nums1[k] = sorted[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
