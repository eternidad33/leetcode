def longestPalindrome(s):
    # # 方法一：哈希
    # d = {}
    # res = 0
    # for c in s:
    #     d[c] = d.get(c, 0) + 1
    #     if d[c] & 1 == 0:
    #         # c出现偶数次，res+2
    #         res += 2
    # # res 比字符串长度短，返回res+1
    # return res + 1 if len(s) != res else res
    # 方法二：数组代替
    l = [0 for _ in range(128)]
    for c in s:
        l[ord(c)] += 1
    ans = 0
    for v in l:
        ans += v // 2 * 2
    return ans + 1 if len(s) != ans else ans
