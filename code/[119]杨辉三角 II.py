# 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
# 
#  在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
# 
#  
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: rowIndex = 3
# 输出: [1,3,3,1]
#  
# 
#  示例 2: 
# 
#  
# 输入: rowIndex = 0
# 输出: [1]
#  
# 
#  示例 3: 
# 
#  
# 输入: rowIndex = 1
# 输出: [1,1]
#  
# 
#  
# 
#  提示: 
# 
#  
#  0 <= rowIndex <= 33 
#  
# 
#  
# 
#  进阶： 
# 
#  你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
#  Related Topics 数组 动态规划 👍 314 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        # 模拟
        ans = list()

        for row_num in range(rowIndex + 1):
            row = [0 for _ in range(row_num + 1)]
            row[-1], row[0] = 1, 1

            for j in range(1, len(row) - 1):
                row[j] = ans[row_num - 1][j - 1] + ans[row_num - 1][j]

            ans.append(row)

        return ans[-1]

# leetcode submit region end(Prohibit modification and deletion)
