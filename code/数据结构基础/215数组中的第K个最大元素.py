from typing import List


def findKthLargest(nums: List[int], k: int) -> int:
    size = len(nums)
    nums.sort()
    return nums[size - k]