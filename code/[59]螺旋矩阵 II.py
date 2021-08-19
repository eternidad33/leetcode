# 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：n = 3
# 输出：[[1,2,3],[8,9,4],[7,6,5]]
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：[[1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 20 
#  
#  Related Topics 数组 矩阵 模拟 👍 465 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        arr = [[0] * n for _ in range(n)]
        c = 1
        j = 0
        while c <= n * n:
            for i in range(j, n - j):
                arr[j][i] = c
                c += 1
            for i in range(j + 1, n - j):
                arr[i][n - j - 1] = c
                c += 1
            for i in range(n - j - 2, j - 1, -1):
                arr[n - j - 1][i] = c
                c += 1
            for i in range(n - j - 2, j, -1):
                arr[i][j] = c
                c += 1
            j += 1
        return arr
# leetcode submit region end(Prohibit modification and deletion)
