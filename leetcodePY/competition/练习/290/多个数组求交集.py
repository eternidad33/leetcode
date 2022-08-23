from typing import List


def intersection(nums: List[List[int]]) -> List[int]:
    s = set(nums[0])
    for i in range(1, len(nums)):
        s = s & set(nums[i])

    return sorted(s)
