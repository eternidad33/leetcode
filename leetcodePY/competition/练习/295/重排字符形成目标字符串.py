from collections import Counter


def rearrangeCharacters(s: str, target: str) -> int:
    ts, tc = Counter(s), Counter(target)
    ret = float('inf')
    for c in tc:
        ret = min(ts[c] // tc[c], ret)
    return ret
