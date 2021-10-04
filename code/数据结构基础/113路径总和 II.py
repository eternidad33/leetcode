from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def pathSum(root: TreeNode, targetSum: int) -> List[List[int]]:
    """113. 路径总和 II"""
    path = list()  # 存储路径
    res = list()  # 存储结果集合

    def dfs(root, target):
        """
        深度优先搜索查找路径总和为target
        :param root: 根节点
        :param target: 要查找的目标值
        """
        if not root:
            return
        # root不为空值时
        path.append(root.val)
        target -= root.val
        if not root.left and not root.right and target == 0:
            """path"""
            res.append(path[:])

        dfs(root.left, target)
        dfs(root.right, target)
        path.pop()

    dfs(root, targetSum)
    return res


if __name__ == '__main__':
    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.right.left = TreeNode(5)
    root.right.right.right = TreeNode(1)
    a = pathSum(root, 22)
    print(a)
