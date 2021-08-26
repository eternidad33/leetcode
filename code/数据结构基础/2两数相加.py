class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    """两数相加"""
    carry = 0
    ans = ListNode()
    head = ans
    while l1 or l2:
        """节点值存在num为val，否则为0"""
        num1 = l1.val if l1 else 0
        num2 = l2.val if l2 else 0
        sum = num1 + num2 + carry
        # tmp存储和的个位数,carry存储和的进位数
        tmp = sum % 10
        ans.next = ListNode(tmp)
        ans = ans.next
        carry = sum // 10
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None
    # 最后可能还含有进位
    if carry:
        ans.next = ListNode(carry)
    return head.next
