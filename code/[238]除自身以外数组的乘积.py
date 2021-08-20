# 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
# 外其余各元素的乘积。 
# 
#  
# 
#  示例: 
# 
#  输入: [1,2,3,4]
# 输出: [24,12,8,6] 
# 
#  
# 
#  提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
# 
#  说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
# 
#  进阶： 
# 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
#  Related Topics 数组 前缀和 👍 891 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # n = len(nums)
        # ans = [1 for _ in range(n)]
        # left = [1 for _ in range(n)]
        # right = [1 for _ in range(n)]
        #
        # for i in range(1, n):
        #     # 乘积为左半部分的乘积
        #     left[i] = left[i - 1] * nums[i - 1]
        # for i in reversed(range(n - 1)):
        #     # 从右向左更新right
        #     right[i] = right[i + 1] * nums[i + 1]
        # for i in range(n):
        #     ans[i] = left[i] * right[i]
        #     print(ans[i], end=' ')
        #
        # return ans

        # 方法二：不开辟数组
        ans = [1 for _ in range(len(nums))]
        for i in range(1, len(nums)):
            ans[i] = ans[i - 1] * nums[i - 1]
        right = 1
        # right用于存储右半部分乘积
        for i in reversed(range(len(nums) - 1)):
            right *= nums[i + 1]
            ans[i] *= right

        return ans
# leetcode submit region end(Prohibit modification and deletion)
