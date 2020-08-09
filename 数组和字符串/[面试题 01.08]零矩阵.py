# 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
# 
#  
# 
#  示例 1： 
# 
#  输入：
# [
#   [1,1,1],
#   [1,0,1],
#   [1,1,1]
# ]
# 输出：
# [
#   [1,0,1],
#   [0,0,0],
#   [1,0,1]
# ]
#  
# 
#  示例 2： 
# 
#  输入：
# [
#   [0,1,2,0],
#   [3,4,5,2],
#   [1,3,1,5]
# ]
# 输出：
# [
#   [0,0,0,0],
#   [0,4,5,0],
#   [0,3,1,0]
# ]
#  
#  Related Topics 数组 
#  👍 13 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        row = []
        col = []
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    row.append(i)
                    col.append(j)
        row = set(row)
        col = set(col)
        for i in row:
            for j in range(len(matrix[i])):
                matrix[i][j] = 0
        for i in col:
            for j in range(len(matrix)):
                matrix[j][i] = 0
# leetcode submit region end(Prohibit modification and deletion)
