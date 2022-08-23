import math
from typing import List


def minMaxGame(nums: List[int]) -> int:
    def rep(nums1):
        return [min(nums1[2 * i], nums1[2 * i + 1]) if i & 1 == 0 else max(nums1[2 * i], nums1[2 * i + 1]) for i in
                range(math.ceil(len(nums1) / 2))]

    while len(nums) != 1:
        nums = rep(nums)
    return nums[0]


nums = [1, 3, 5, 2, 4, 8, 2, 2]
print(minMaxGame(nums))
