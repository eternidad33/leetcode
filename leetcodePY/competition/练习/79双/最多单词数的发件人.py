from typing import List


def largestWordCount(messages: List[str], senders: List[str]) -> str:
    d = {}
    for i in range(len(senders)):
        d[senders[i]] = d.get(senders[i], 0) + len(messages[i].split())

    ans = []
    # 遍历字典
    keys = list(d.keys())
    values = list(d.values())
    maxNum = max(values)
    for i in range(len(values)):
        if values[i] == maxNum:
            ans.append(keys[i])
    ans.sort()
    return ans[-1]
