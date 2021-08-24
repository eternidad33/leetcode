import collections


def groupAnagrams(strs):
    mp = collections.defaultdict(list)

    # 方法一：排序
    for st in strs:
        key = "".join(sorted(st))
        mp[key].append(st)

    # 方法二：计数
    # for st in strs:
    #     counts = [0] * 26
    #     for ch in st:
    #         counts[ord(ch) - ord("a")] += 1
    #     # 需要将 list 转换成 tuple 才能进行哈希
    #     mp[tuple(counts)].append(st)

    return list(mp.values())


