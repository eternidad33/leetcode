from typing import List


def findClosestNumber(nums: List[int]) -> int:
    nums.sort(key=lambda x: [abs(x), -x])
    return nums[0]


nums = [-4, -1, 1, -1, 8]
print(findClosestNumber(nums))
