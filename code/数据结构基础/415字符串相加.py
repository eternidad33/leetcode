def addStrings(num1, num2):
    # 方法一：调用int
    # a, b = int(num1), int(num2)
    # return str(a + b)

    # 方法二：模拟
    carry = 0
    i, j = len(num1) - 1, len(num2) - 1
    res = ""
    while i >= 0 or j >= 0:
        # 缺位补0
        a = int(num1[i]) if i >= 0 else 0
        b = int(num2[j]) if j >= 0 else 0
        temp = a + b + carry
        carry = temp // 10
        res = str(temp % 10) + res
        i, j = i - 1, j - 1
    return "1" + res if carry else res
