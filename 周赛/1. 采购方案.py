from typing import List


class Solution:
    def purchasePlans1(self, nums: List[int], target: int) -> int:
        if not nums or len(nums) == 0:
            return 0
        count = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] <= target:
                    count += 1
        return count
