# 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
# 
#  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
# 
#  说明：不允许修改给定的链表。 
# 
#  
# 
#  示例 1： 
# 
#  输入：head = [3,2,0,-4], pos = 1
# 输出：tail connects to node index 1
# 解释：链表中有一个环，其尾部连接到第二个节点。
#  
# 
#  
# 
#  示例 2： 
# 
#  输入：head = [1,2], pos = 0
# 输出：tail connects to node index 0
# 解释：链表中有一个环，其尾部连接到第一个节点。
#  
# 
#  
# 
#  示例 3： 
# 
#  输入：head = [1], pos = -1
# 输出：no cycle
# 解释：链表中没有环。
#  
# 
#  
# 
#  
# 
#  进阶： 
# 你是否可以不用额外空间解决此题？ 
#  Related Topics 链表 双指针 
#  👍 642 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        hashSet = set()
        node = head
        while node is not None:
            if node in hashSet:
                return node
            else:
                hashSet.add(node)
                node = node.next
        return None

# leetcode submit region end(Prohibit modification and deletion)
