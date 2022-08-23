from typing import List


def maxConsecutive(bottom: int, top: int, special: List[int]) -> int:
    ans = 0
    special.sort()
    n = len(special)
    for i in range(1, n):
        ans = max(ans, special[i] - special[i - 1] - 1)
    return max(ans, special[0] - bottom, top - special[-1])
