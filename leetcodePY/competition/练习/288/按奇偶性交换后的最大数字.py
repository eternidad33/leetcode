def largestInteger(nums):
    s = list(map(int, str(nums)))
    for i in range(len(s)):
        for j in range(i + 1, len(s)):
            if (s[i] - s[j]) % 2 == 0 and s[j] > s[i]:
                s[i], s[j] = s[j], s[i]
    return int("".join(map(str, s)))


print(largestInteger(36521))
