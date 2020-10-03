# 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
#  0。 
# 
#  
# 
#  示例： 
# 
#  输入：s = 7, nums = [2,3,1,2,4,3]
# 输出：2
# 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
#  
# 
#  
# 
#  进阶： 
# 
#  
#  如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
#  
#  Related Topics 数组 双指针 二分查找 
#  👍 463 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        # 若为空数组返回0
        if n == 0:
            return 0

        start, end = 0, 0
        s0, ans = 0, n + 1

        while end < n:
            s0 += nums[end]
            # 当连续和大于s时，移动开始指针
            while s0 >= s:
                ans = min(ans, end - start + 1)
                s0 -= nums[start]
                start += 1
            end += 1

        return 0 if ans == n + 1 else ans
# leetcode submit region end(Prohibit modification and deletion)
