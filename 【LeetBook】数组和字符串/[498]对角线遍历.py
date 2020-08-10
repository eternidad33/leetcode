# 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
# 
#  
# 
#  示例: 
# 
#  输入:
# [
#  [ 1, 2, 3 ],
#  [ 4, 5, 6 ],
#  [ 7, 8, 9 ]
# ]
# 
# 输出:  [1,2,4,7,5,3,6,8,9]
# 
# 解释:
# 
#  
# 
#  
# 
#  说明: 
# 
#  
#  给定矩阵中的元素总数不会超过 100000 。 
#  
#  👍 114 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        # 空矩阵
        if not matrix or not matrix[0]:
            return []

        # 存储矩阵的行数和列数
        n, m = len(matrix), len(matrix[0])

        # result 保存输出结果，intermediate 保存对角线序列
        result, intermediate = [], []

        # 一共有 n+m-1 条对角线
        for d in range(n + m - 1):
            intermediate = []

            # 保存每条对角线的第一个元素的行号和列号
            row = 0 if d < m else d - m + 1
            col = d if d < m else m - 1
            # 遍历对角线
            while row < n and col > -1:
                intermediate.append(matrix[row][col])
                row += 1
                col -= 1

            # 判断对角线的奇偶数，偶数对角线逆序
            if d % 2 == 0:
                result.extend(intermediate[::-1])
            else:
                result.extend(intermediate)
        return result
# leetcode submit region end(Prohibit modification and deletion)
