//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        /*思路：
        1.创建small,large两个链表，分别存储小于x,大于x的元素
        2.遍历
         */
        //创建两个链表
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        //设置头节点
        ListNode smallHead = small;
        ListNode largeHead = large;

        //用head遍历原始链表
        while (head != null) {
            //节点值小于x，插入到small链表
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                //插入到large链表
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        //连接两个链表
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
