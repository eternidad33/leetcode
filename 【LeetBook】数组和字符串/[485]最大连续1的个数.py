# 给定一个二进制数组， 计算其中最大连续1的个数。 
# 
#  示例 1: 
# 
#  
# 输入: [1,1,0,1,1,1]
# 输出: 3
# 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
#  
# 
#  注意： 
# 
#  
#  输入的数组只包含 0 和1。 
#  输入数组的长度是正整数，且不超过 10,000。 
#  
#  Related Topics 数组 
#  👍 127 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 分别记录连续1的个数和最大连续个数
        count, maxcount = 0, 0
        for num in nums:
            if num == 1:
                count += 1
            else:
                maxcount = max(count, maxcount)
                count = 0
        return max(count, maxcount)

# leetcode submit region end(Prohibit modification and deletion)
