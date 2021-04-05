from typing import List


class Solution:
    def purchasePlans(self, nums: List[int], target: int) -> int:
        # # 超时
        # if not nums or len(nums) == 0:
        #     return 0
        # count = 0
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] <= target:
        #             count += 1
        # return count

        # 双指针
        nums.sort()
        i, j, res = 0, len(nums) - 1, 0
        while i < j:
            if nums[i] + nums[j] > target:
                j -= 1
            else:
                res += (j - i)
                i += 1
        return res % 1000000007


s = Solution()
print(s.purchasePlans([2, 5, 3, 5], 6))
