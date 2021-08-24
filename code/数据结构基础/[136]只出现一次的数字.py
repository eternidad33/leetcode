# 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
# 
#  说明： 
# 
#  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
# 
#  示例 1: 
# 
#  输入: [2,2,1]
# 输出: 1
#  
# 
#  示例 2: 
# 
#  输入: [4,1,2,1,2]
# 输出: 4 
#  Related Topics 位运算 数组 👍 1969 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # 方法一：集合
        # s = set()
        # for num in nums:
        #     if num not in s:
        #         s.add(num)
        #     else:
        #         s.remove(num)
        # return s.pop()

        # 方法二：哈希
        # d = {}
        # for num in nums:
        #     if num not in d:
        #         d[num] = 1
        #     else:
        #         d[num] += 1
        # for a in d:
        #     if d[a] == 1:
        #         return a
        # return -1

        # 方法三：集合，数组之和
        # s = set(nums)
        # s1, s2 = sum(nums), sum(s) * 2
        # return s2 - s1

        # 方法四：位运算
        res = 0
        for num in nums:
            res ^= num
        return res

# leetcode submit region end(Prohibit modification and deletion)
