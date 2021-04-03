# 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
# 一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
# 
#  [["a","b","c","e"], 
# ["s","f","c","s"], 
# ["a","d","e","e"]] 
# 
#  但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
# CCED"
# 输出：true
#  
# 
#  示例 2： 
# 
#  
# 输入：board = [["a","b"],["c","d"]], word = "abcd"
# 输出：false
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= board.length <= 200 
#  1 <= board[i].length <= 200 
#  
# 
#  注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
#  Related Topics 深度优先搜索 
#  👍 289 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i, j, k):
            if not 0 <= i < len(board) or not 0 <= j < len(board[0]) or board[i][j] != word[k]:
                return False
            # 当k到字符串末尾，返回True
            if k == len(word) - 1:
                return True
            board[i][j] = ''
            res = dfs(i, j - 1, k + 1) or dfs(i, j + 1, k + 1) or dfs(i - 1, j, k + 1) or dfs(i + 1, j, k + 1)
            board[i][j] = word[k]
            return res

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0): return True
        return False


# leetcode submit region end(Prohibit modification and deletion)


board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
word = "ABCCED"
s = Solution()
print(s.exist(board, word))
