class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sortedArrayToBST(nums) -> TreeNode:
    # 递归
    if not nums:
        return None

    mid = len(nums) // 2
    tn = TreeNode(nums[mid])
    nums1 = nums[0:mid]
    nums2 = nums[mid + 1:len(nums)]
    tn.left = sortedArrayToBST(nums1)
    tn.right = sortedArrayToBST(nums2)
    return tn
