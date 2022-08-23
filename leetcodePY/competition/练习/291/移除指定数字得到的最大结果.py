def removeDigit(number: str, digit: str) -> str:
    res = ''
    n = len(number)
    for i in range(n):
        if number[i] == digit:
            tmp = number[:i] + number[i + 1:]
            res = max(res, tmp)
    return res
