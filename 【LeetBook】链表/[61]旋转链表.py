# 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
# 
#  示例 1: 
# 
#  输入: 1->2->3->4->5->NULL, k = 2
# 输出: 4->5->1->2->3->NULL
# 解释:
# 向右旋转 1 步: 5->1->2->3->4->NULL
# 向右旋转 2 步: 4->5->1->2->3->NULL
#  
# 
#  示例 2: 
# 
#  输入: 0->1->2->NULL, k = 4
# 输出: 2->0->1->NULL
# 解释:
# 向右旋转 1 步: 2->0->1->NULL
# 向右旋转 2 步: 1->2->0->NULL
# 向右旋转 3 步: 0->1->2->NULL
# 向右旋转 4 步: 2->0->1->NULL 
#  Related Topics 链表 双指针 
#  👍 350 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        # 链表为空
        if not head:
            return None
        # 只有一个节点
        if not head.next:
            return head

        # 寻找旧的尾节点,并求链表的长度
        length = 1
        old = head
        while old.next:
            old = old.next
            length += 1
        # 头尾相连
        old.next = head

        # 寻找第（n-k%n-1）个节点，是新的尾节点
        new = head
        for i in range(length - k % length - 1):
            new = new.next
        new_head = new.next
        new.next = None
        return new_head

# leetcode submit region end(Prohibit modification and deletion)
