class Solution:
    def orchestraLayout(self, num: int, xPos: int, yPos: int) -> int:
        x, y, n = xPos, yPos, num
        if x <= y:
            k = min(x, n - y - 1)
            return (4 * k * (n - k) + 1 + (x + y - 2 * k) - 1) % 9 + 1
        k = min(y, n - 1 - x) + 1
        return (4 * k * (n - k) + 1 - ((x + y) - (k - 1) * 2) - 1) % 9 + 1


#         # 构建矩阵（超时）
#         board = [[i for i in range(num)] for j in range(num)]
#         count, index = 0, 1
#         # count代表圈数，偶数为 num/2 圈，奇数为(num/2+1)圈
#         r = num / 2 if num % 2 else num / 2 + 1
#         while count < r:
#             i, j = count, count
#             # 上边，向右移动，(count,count)->(count,num-count-1)
#             while j < num - count:
#                 index = 1 if index > 9 else index
#                 board[i][j] = index
#                 index += 1
#                 j += 1
#             # 右边，向下移动,(count+1,num-count-1)->(num-count-1,num-count-1)
#             i, j = count + 1, num - count - 1
#             while i < num - count:
#                 index = 1 if index > 9 else index
#                 board[i][j] = index
#                 index += 1
#                 i += 1
#             # 下边，向左移动,(num-count-1,num-count-2)->(num-count-1,count+1)
#             i, j = num - count - 1, num - count - 2
#             while j > count:
#                 index = 1 if index > 9 else index
#                 board[i][j] = index
#                 index += 1
#                 j -= 1
#             # 左边，向上移动,(num-count-1,count)->(count+1,count)
#             i, j = num - count - 1, count
#             while i > count:
#                 index = 1 if index > 9 else index
#                 board[i][j] = index
#                 index += 1
#                 i -= 1
#             count += 1
#         for i in range(num):
#             for j in range(num):
#                 print(board[i][j], end=' ')
#             print()
#         return board[xPos][yPos]


s = Solution()
a = s.orchestraLayout(6, 3, 3)
print(a)
