# 二叉搜索树中的两个节点被错误地交换。 
# 
#  请在不改变其结构的情况下，恢复这棵树。 
# 
#  示例 1: 
# 
#  输入: [1,3,null,null,2]
# 
#    1
#   /
#  3
#   \
#    2
# 
# 输出: [3,1,null,null,2]
# 
#    3
#   /
#  1
#   \
#    2
#  
# 
#  示例 2: 
# 
#  输入: [3,1,4,null,null,2]
# 
#   3
#  / \
# 1   4
#    /
#   2
# 
# 输出: [2,1,4,null,null,3]
# 
#   2
#  / \
# 1   4
#    /
#   3 
# 
#  进阶: 
# 
#  
#  使用 O(n) 空间复杂度的解法很容易实现。 
#  你能想出一个只使用常数空间的解决方案吗？ 
#  
#  Related Topics 树 深度优先搜索 
#  👍 278 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        Trees = lambda x: [] if not x else Trees(x.left) + [x] + Trees(x.right)
        a = Trees(root)
        sa = sorted(a, key=lambda x: x.val)
        tmp = [a[i] for i in range(len(a)) if a[i] != sa[i]]
        tmp[0].val, tmp[1].val = tmp[1].val, tmp[0].val
# leetcode submit region end(Prohibit modification and deletion)
