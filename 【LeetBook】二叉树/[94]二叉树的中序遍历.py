# 给定一个二叉树，返回它的中序 遍历。 
# 
#  示例: 
# 
#  输入: [1,null,2,3]
#    1
#     \
#      2
#     /
#    3
# 
# 输出: [1,3,2] 
# 
#  进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
#  Related Topics 栈 树 哈希表 
#  👍 753 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        def medium(root, res):
            if not root:
                return None
            medium(root.left, res)
            res.append(root.val)
            medium(root.right, res)

        res = []
        medium(root, res)
        return res
        
# leetcode submit region end(Prohibit modification and deletion)
