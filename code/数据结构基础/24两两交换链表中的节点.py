class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def swapPairs(head: ListNode):
    dumy = ListNode(0)
    dumy.next = head
    temp = dumy
    while temp.next and temp.next.next:
        # 两个节点node1，node2
        node1 = temp.next
        node2 = temp.next.next
        # 交换
        temp.next = node2
        node1.next = node2.next
        node2.next = node1
        # temp前移
        temp = node1
    return dumy.next
