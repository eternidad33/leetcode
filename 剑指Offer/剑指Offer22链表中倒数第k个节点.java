// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾节点是倒数第1个节点。
// 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
// 这个链表的倒数第3个节点是值为4的节点。
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 127 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
//        //方法1：直接法(超时）
//        ListNode p = new ListNode(0);
//        p.next = head;
//        int n = 0;
//        while (p != null) {
//            n++;
//        }
//        System.out.println("一共有：" + n + "个节点");
//        k = k % n;
//        for (int i = 0; i < n - k + 1; i++) {
//            head = head.next;
//        }
//        return head;
        //方法2：双指针(0ms)
        ListNode first = head, last = head;
        //第一个指针先走k步
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        //第二个指针走n-k步
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }
}

/**
 * Definition for singly-linked list.
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
