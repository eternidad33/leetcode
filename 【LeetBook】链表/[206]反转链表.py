# 反转一个单链表。 
# 
#  示例: 
# 
#  输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL 
# 
#  进阶: 
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
#  Related Topics 链表 
#  👍 1264 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pre = None
        curr = head
        while curr is not None:
            temp_node = curr.next
            curr.next = pre
            pre = curr
            curr = temp_node
        return pre

# leetcode submit region end(Prohibit modification and deletion)
