class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def detectCycle(head: ListNode):
    """环形链表"""
    hash = set()
    while head:
        if head in hash:
            return head
        else:
            hash.add(head)
        head = head.next
    return None
