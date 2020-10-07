# 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
# 
#  示例： 
# 
#  给定一个链表: 1->2->3->4->5, 和 n = 2.
# 
# 当删除了倒数第二个节点后，链表变为 1->2->3->5.
#  
# 
#  说明： 
# 
#  给定的 n 保证是有效的。 
# 
#  进阶： 
# 
#  你能尝试使用一趟扫描实现吗？ 
#  Related Topics 链表 双指针 
#  👍 1014 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dump = ListNode(0)
        dump.next = head

        curr, length = head, 0
        while curr:
            curr = curr.next
            length += 1

        # 获取要删除节点的前一个结点
        curr = dump
        for _ in range(length - n):
            curr = curr.next

        curr.next = curr.next.next
        return dump.next

# leetcode submit region end(Prohibit modification and deletion)
