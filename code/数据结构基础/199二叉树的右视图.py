from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def rightSideView(root: TreeNode) -> List[int]:
    """二叉树的右视图"""
    res = []

    def dfs(root, depth):
        if not root:
            return
        if depth == len(res):
            res.append(root.val)
        depth += 1
        dfs(root.right, depth)
        dfs(root.left, depth)

    dfs(root, 0)
    return res

    # if not root:
    #     return []
    # res = []  # 存出结果
    # q = deque([root])
    #
    # while q:
    #     size = len(q)
    #     for i in range(size):
    #         node = q.popleft()
    #         if node.left:
    #             q.append(node.left)
    #         if node.right:
    #             q.append(node.right)
    #         if i == size - 1:
    #             res.append(node.val)
    # return res
