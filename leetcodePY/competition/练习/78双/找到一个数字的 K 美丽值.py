def divisorSubstrings(num: int, k: int):
    res = 0
    snum = str(num)
    for i in range(len(snum) - k + 1):
        print(i)
        tmp = int(snum[i:i + k])
        if tmp == 0:
            continue
        if num % tmp == 0:
            res += 1
            print(tmp)

    return res
