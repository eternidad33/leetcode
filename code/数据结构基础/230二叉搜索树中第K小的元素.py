class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def kthSmallest(root: TreeNode, k: int) -> int:
    # def inorder(root):
    #     return inorder(root.left) + [root.val] + inorder(root.right) if root else []
    #
    # return inorder(root)[k - 1]
    stack = []
    while True:
        while root:
            stack.append(root)
            root = root.left

        root = stack.pop()
        k -= 1
        if not k:
            return root.val
        root = root.right
