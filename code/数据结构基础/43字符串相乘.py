def multiply(num1: str, num2: str):
    """字符串相乘"""
    # 方法一：调用int
    # return str(int(num1) * int(num2))

    # 方法二：模拟加法
    if num1 == '0' or num2 == '0':
        return '0'
    ans = "0"
    m, n = len(num1), len(num2)
    for i in range(n - 1, -1, -1):
        carry = 0
        y = int(num2[i])
        curr = ["0"] * (n - i - 1)
        for j in range(m - 1, -1, -1):
            # 逐位相乘，并加上前一位的进位
            product = int(num1[j]) * y + carry
            # 将个位数加到curr数组中
            curr.append(str(product % 10))
            # carry存储相乘后的进位
            carry = product // 10
        if carry > 0:
            curr.append(str(carry))
        curr = "".join(curr[::-1])
        ans = addStrings(ans, curr)

    return ans


def addStrings(num1, num2):
    """题415，字符串相加"""
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
