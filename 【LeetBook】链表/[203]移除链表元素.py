# 删除链表中等于给定值 val 的所有节点。 
# 
#  示例: 
# 
#  输入: 1->2->6->3->4->5->6, val = 6
# 输出: 1->2->3->4->5
#  
#  Related Topics 链表 
#  👍 458 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        p = ListNode(0)
        p.next = head

        pre, curr = p, head
        while curr:
            if curr.val == val:
                pre.next = curr.next
            else:
                pre = curr
            curr = curr.next

        return p.next

# leetcode submit region end(Prohibit modification and deletion)
