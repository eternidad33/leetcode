from typing import List


def maximumBags(capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
    count = 0
    diffs = []
    for i in range(len(capacity)):
        diff = capacity[i] - rocks[i]
        diffs.append(diff)
    diffs.sort()
    for diff in diffs:
        if additionalRocks >= diff:
            additionalRocks -= diff
            count += 1
    return count
