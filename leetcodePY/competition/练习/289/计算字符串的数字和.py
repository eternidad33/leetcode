def digitSum(s: str, k: int) -> str:
    while len(s) > k:
        t = ''
        for i in range(0, len(s), k):
            t += str(sum(map(int, s[i:k + i])))
        s = t
    return s


print(digitSum('123456789', 3))
