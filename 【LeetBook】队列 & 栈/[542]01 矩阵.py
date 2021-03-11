# 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
# 
#  两个相邻元素间的距离为 1 。 
# 
#  示例 1: 
# 输入: 
# 
#  
# 0 0 0
# 0 1 0
# 0 0 0
#  
# 
#  输出: 
# 
#  
# 0 0 0
# 0 1 0
# 0 0 0
#  
# 
#  示例 2: 
# 输入: 
# 
#  
# 0 0 0
# 0 1 0
# 1 1 1
#  
# 
#  输出: 
# 
#  
# 0 0 0
# 0 1 0
# 1 2 1
#  
# 
#  注意: 
# 
#  
#  给定矩阵的元素个数不超过 10000。 
#  给定矩阵中至少有一个元素是 0。 
#  矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
#  
#  Related Topics 深度优先搜索 广度优先搜索 
#  👍 332 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections
from typing import List


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        # 记录每个点距离0的距离
        dist = [[0] * n for _ in range(m)]
        zero_pos = [(i, j) for i in range(m) for j in range(n) if matrix[i][j] == 0]
        # 把0的位置存入队列
        q = collections.deque(zero_pos)
        seen = set(zero_pos)

        # 广度优先搜素
        while q:
            i, j = q.popleft()
            for ni, nj in [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)]:
                if 0 <= ni < m and 0 <= nj < n and (ni, nj) not in seen:
                    dist[ni][nj] = dist[i][j] + 1
                    q.append((ni, nj))
                    seen.add((ni, nj))

        return dist

# leetcode submit region end(Prohibit modification and deletion)
