def partitionLabels(s: str):
    """划分字母区间"""
    last = [0 for i in range(26)]
    for i, c in enumerate(s):
        last[ord(c) - ord('a')] = i
    start, end = 0, 0
    res = []
    for i in range(len(s)):
        end = max(end, last[ord(s[i]) - ord('a')])
        if i == end:
            res.append(end - start + 1)
            start = end + 1
    return res
