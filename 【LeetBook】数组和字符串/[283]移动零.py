# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
# 
#  示例: 
# 
#  输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0] 
# 
#  说明: 
# 
#  
#  必须在原数组上操作，不能拷贝额外的数组。 
#  尽量减少操作次数。 
#  
#  Related Topics 数组 双指针 
#  👍 751 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if nums == 0:
            return None
        a = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[a] = nums[i]
                a += 1
        for j in range(a, len(nums)):
            nums[j] = 0
# leetcode submit region end(Prohibit modification and deletion)
