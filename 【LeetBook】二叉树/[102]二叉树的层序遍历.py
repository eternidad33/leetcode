# 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
# 
#  
# 
#  示例： 
# 二叉树：[3,9,20,null,null,15,7], 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
# 
#  返回其层次遍历结果： 
# 
#  [
#   [3],
#   [9,20],
#   [15,7]
# ]
#  
#  Related Topics 树 广度优先搜索 
#  👍 673 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        queue = collections.deque()
        queue.append(root)
        while queue:
            level = []
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                if not curr:
                    continue
                level.append(curr.val)
                queue.append(curr.left)
                queue.append(curr.right)
            if level:
                res.append(level)
        return res
# leetcode submit region end(Prohibit modification and deletion)
