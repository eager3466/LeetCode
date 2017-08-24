package medium;

import data.ListNode;

/**
 * Created by eager-mbp on 2017/8/19.
 */
public class ReverseLinkedListII {

//    Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//    For example:
//    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//            Note:
//    Given m, n satisfy the following condition:
//            1 ? m ? n ? length of list.

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            // 这句非常精髓，看似没有了start = start.next这样的循环驱动
            // 但实际上也是不断让结点前行的一个办法
            // 因为前面已经交代好了pre和then之间的关系，这里把then指向下一个需要reverse的结点即可
            then = start.next;
        }
        return dummy.next;
    }
}
