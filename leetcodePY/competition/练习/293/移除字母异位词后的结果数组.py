from collections import Counter
from typing import List


def removeAnagrams(words: List[str]) -> List[str]:
    n = len(words)
    res = []
    res.append(words[0])

    for i in range(1, n):
        if Counter(words[i]) != Counter(res[-1]):
            res.append(words[i])

    return res
