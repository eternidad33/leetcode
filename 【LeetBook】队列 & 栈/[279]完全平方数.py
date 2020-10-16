# 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
# 
#  示例 1: 
# 
#  输入: n = 12
# 输出: 3 
# 解释: 12 = 4 + 4 + 4. 
# 
#  示例 2: 
# 
#  输入: n = 13
# 输出: 2
# 解释: 13 = 4 + 9. 
#  Related Topics 广度优先搜索 数学 动态规划 
#  👍 634 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        from collections import deque
        deq = deque()
        # 存储已经遍历过的值
        visited = set()

        deq.append((n, 0))
        while deq:
            number, step = deq.popleft()
            targets = [number - i * i for i in range(1, int(number ** 0.5) + 1)]
            for target in targets:
                if target in targets:
                    if target == 0:
                        return step + 1
                    if target not in visited:
                        deq.append((target, step + 1))
                        visited.add(target)
        return 0
# leetcode submit region end(Prohibit modification and deletion)
