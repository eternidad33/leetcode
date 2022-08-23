from string import ascii_lowercase
from typing import List


# class Solution:
#     def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
#         """
#         超时
#         :param s: 待转换的字符串
#         :param shifts: 要进行的操作
#         :return:
#         """
#         ls = list(s)
#         for shift in shifts:
#             start, end = shift[0], shift[1]
#             for i in range(start, end + 1):
#                 # 判断shift[2]的值，1后移，0前移
#                 if shift[2] == 1:
#                     # 字符右移
#                     ls[i] = self.moveRight(ls[i])
#                 else:
#                     # 字符左移
#                     ls[i] = self.moveLeft(ls[i])
#         return ''.join(ls)
#
#     def moveLeft(self, c):
#         """字符左移"""
#         if c == 'a':
#             return 'z'
#         else:
#             return chr(ord(c) - 1)
#
#     def moveRight(self, c):
#         """字符右移"""
#         if c == 'z':
#             return 'a'
#         else:
#             return chr(ord(c) + 1)

#
# class Solution:
#     def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
#         # 先遍历计数
#         n = len(s)
#         cnt = [0] * n
#         for shift in shifts:
#             for i in range(shift[0], shift[1] + 1):
#                 if shift[2] == 1:
#                     cnt[i] += 1
#                 else:
#                     cnt[i] -= 1
#         # 对每个字符进行移位
#         res = []
#         for i in range(n):
#             res.append(self.move(s[i], cnt[i]))
#         return ''.join(res)
#
#     def move(self, c, cnt):
#         # a~z在97~122之间，所以可以直接使用ord()函数获取字符的ASCII码
#         index = ord(c) + cnt
#         while index > 122 or index < 97:
#             if index > 122:
#                 index = 97 + (index - 122) - 1
#             if index < 97:
#                 index = 122 - (97 - index) + 1
#         return chr(index)
class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        # 差分数组
        n = len(s)
        diff = [0] * (n + 1)
        diff[0] = ord(s[0]) - ord('a')
        # 初始化差分数组
        for i in range(1, len(s)):
            diff[i] = ord(s[i]) - ord(s[i - 1])

        # 区间变更
        for shift in shifts:
            if shift[2]:
                diff[shift[0]] += 1
                diff[shift[1] + 1] -= 1
            else:
                diff[shift[0]] -= 1
                diff[shift[1] + 1] += 1

        # 前缀和
        for i in range(1, len(diff)):
            diff[i] += diff[i - 1]

        for i in range(len(diff)):
            # diff[i]可能为负数
            while diff[i] < 0:
                diff[i] += 26
            diff[i] %= 26
            diff[i] += ord('a')
            diff[i] = chr(diff[i])

        return ''.join(diff[:-1])


s = "dztz"
shifts = [[0, 0, 0], [1, 1, 1]]
print(Solution().shiftingLetters(s, shifts))
