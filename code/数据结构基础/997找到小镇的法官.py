from typing import List


def findJudge(N: int, trust: List[List[int]]) -> int:
    # a存储相信你的人的数目，b存储你相信的人的数目
    a = [0 for _ in range(N + 1)]
    b = [0 for _ in range(N + 1)]

    for num in trust:
        a[num[1]] += 1
        b[num[0]] += 1

    for i, num in enumerate(a):
        if i != 0 and num == N - 1:
            if b[i] == 0:
                """法官不允许相信任何人"""
                return i

    return -1
