from typing import List


def minimumSwitchingTimes(source: List[List[int]], target: List[List[int]]) -> int:
    count = 0
    m = dict()  # 哈希表
    for s0 in source:
        for s in s0:
            m[s] = m.get(s, 0) + 1

    for s1 in target:
        for s in s1:
            if m.get(s, 0) > 0:
                """source中存在这个数"""
                m[s] -= 1
            else:
                count += 1

    return count
