def findRepeatedDnaSequences(s: str):
    """重复的DNA序列"""
    # 方法一：滑动窗口
    # hash_set = set()
    # ans = set()
    # if len(s) < 10:
    #     return ans
    # for i in range(len(s) - 10 + 1):
    #     tmp = s[i:i + 10]
    #     # 判断tmp是否在哈希表中
    #     if tmp in hash_set:
    #         ans.add(tmp)
    #     else:
    #         hash_set.add(tmp)
    # return list(ans)

    # 方法二：旋转哈希（Rabin-Karp）
    l, n = 10, len(s)
    if n <= l:
        return []

    a = 4
    al = pow(a, l)

    # 将字符转换成对应的
    to_int = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
    nums = [to_int.get(s[i]) for i in range(n)]

    h = 0
    seen, output = set(), set()
    # 遍历字符串
    for start in range(n - l + 1):
        if start != 0:
            # 起始位置不是索引为0的情况
            h = h * a - nums[start - 1] * al + nums[start + l - 1]
        else:
            # 计算一开始的哈希值
            for i in range(l):
                h = h * a + nums[i]
        # 更新哈希集合和返回结果
        if h in seen:
            output.add(s[start:start + l])
        seen.add(h)
    return list(output)
