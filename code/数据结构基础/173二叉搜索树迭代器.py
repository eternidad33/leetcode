class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.index = 0
        self.arr = []
        self.inorder(root, self.arr)

    def inorder(self, root, arr):
        if not root:
            return
        self.inorder(root.left, arr)
        arr.append(root.val)
        self.inorder(root.right, arr)

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        self.index += 1
        return self.arr[self.index - 1]

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return self.index < len(self.arr)
