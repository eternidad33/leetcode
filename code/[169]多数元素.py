# 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
# 
#  你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：[3,2,3]
# 输出：3 
# 
#  示例 2： 
# 
#  
# 输入：[2,2,1,1,1,2,2]
# 输出：2
#  
# 
#  
# 
#  进阶： 
# 
#  
#  尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
#  
#  Related Topics 数组 哈希表 分治 计数 排序 👍 1097 👎 0


from typing import List


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 方法一：哈希表
        # d = {}
        # for num in nums:
        #     if num not in d:
        #         d[num] = 1
        #     else:
        #         d[num] += 1
        # max_key, max_value = -1, -1
        # for k in d:
        #     if d[k] > max_value:
        #         max_key = k
        #         max_value = d[k]
        # return max_key
        #
        # counts = collections.Counter(nums)
        # return max(counts.keys(), key=counts.get)

        # 方法二：排序
        # nums.sort()
        # return nums[len(nums) // 2]

        # 方法三：分治递归
        # def majority_element_rec(left, right):
        #     """查找left到right之间的众数"""
        #     if left == right:
        #         """索引相同，区间长度为1"""
        #         return nums[left]
        #
        #     # 划分区间
        #     mid = left + (right - left) // 2
        #     left_majority = majority_element_rec(left, mid)
        #     right_majority = majority_element_rec(mid + 1, right)
        #
        #     if left_majority == right_majority:
        #         return left_majority
        #
        #     # 比较整个区间两个众数的数量
        #     left_count = sum(1 for i in range(left, right + 1) if nums[i] == left_majority)
        #     right_count = sum(1 for i in range(left, right + 1) if nums[i] == right_majority)
        #     print(str(left_count) + ' ' + str(right_count))
        #     return left_majority if left_count > right_count else right_majority
        #
        # return majority_element_rec(0, len(nums) - 1)

        # 方法四：摩尔投票法
        if not nums:
            return -1
        target, cnt = nums[0], 0
        for n in nums:
            if target == n:
                cnt += 1
            else:
                cnt -= 1
            if cnt == -1:
                target = n
                cnt = 0
        return target

        # count = 0
        # candidate = None
        #
        # for num in nums:
        #     if count == 0:
        #         candidate = num
        #     count += (1 if num == candidate else -1)
        #
        # return candidate
# leetcode submit region end(Prohibit modification and deletion)
