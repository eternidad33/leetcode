from typing import List


def maxmiumScore(cards: List[int], cnt: int) -> int:
    # 逆序排序
    cards.sort(reverse=True)

    odd, even = [0], [0]  # 奇偶数组用于存储前缀和
    for card in cards:
        if card & 1:
            """奇数"""
            odd.append(odd[-1] + card)
        else:
            even.append(even[-1] + card)

    ans = 0
    for k in range(0, len(odd), 2):
        """枚举奇数的个数，步长为2"""
        if 0 <= cnt - k < len(even):
            ans = max(ans, odd[k] + even[cnt - k])
    return ans


s = maxmiumScore([3, 3, 1], 3)
print(s)
