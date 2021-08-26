class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def getIntersectionNode(headA: ListNode, headB: ListNode):
    """相交链表"""
    hash = set()
    while headA:
        hash.add(headA)
        headA = headA.next
    while headB:
        if headB in hash:
            return headB
        headB = headB.next
    return None
