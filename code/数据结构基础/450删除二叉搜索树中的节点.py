class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def successor(self, root):
        """
        查找后继节点，右子树的最左节点
        """
        root = root.right
        while root.left:
            root = root.left
        return root.val

    def predecessor(self, root):
        """
        查找前驱节点，左子树的最右节点
        """
        root = root.left
        while root.right:
            root = root.right
        return root.val

    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None

        # 从右子树删除节点
        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        # 从左子树删除节点
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        # 删除当前节点，可能是叶子节点，也可能是非叶子节点
        else:
            # 叶节点直接删除
            if not (root.left or root.right):
                root = None
            # 有右孩子，则从右子树查找直接后继值替换，从右子树删除这个值
            elif root.right:
                root.val = self.successor(root)
                root.right = self.deleteNode(root.right, root.val)
            # 从左子树删除
            else:
                root.val = self.predecessor(root)
                root.left = self.deleteNode(root.left, root.val)

        return root
