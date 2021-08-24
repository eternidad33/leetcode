# 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
# 
#  示例 1 : 
# 
#  
# 输入:nums = [1,1,1], k = 2
# 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
#  
# 
#  说明 : 
# 
#  
#  数组的长度为 [1, 20,000]。 
#  数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
#  
#  Related Topics 数组 哈希表 前缀和 👍 1052 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # # 方法一：枚举
        # count = 0
        # for start in range(len(nums)):
        #     sum = 0
        #     for end in range(start, -1, -1):
        #         sum += nums[end]
        #         if sum == k:
        #             count += 1
        # return count

        # 方法二：哈希+前缀和
        # 建立哈希表
        mp = dict()
        count, pre = 0, 0
        mp[0] = 1
        for i in range(len(nums)):
            # pre用于存储前缀和
            pre += nums[i]
            if mp.get(pre - k):
                count += mp.get(pre - k)
            mp[pre] = mp.get(pre, 0) + 1
        return count
# leetcode submit region end(Prohibit modification and deletion)
