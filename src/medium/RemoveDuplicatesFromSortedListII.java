package medium;

import data.ListNode;

/**
 * Created by Eager-RESCUER on 2017/8/8
 */
public class RemoveDuplicatesFromSortedListII {

//    Given a sorted linked list, delete all nodes that have duplicate numbers,
//    leaving only distinct numbers from the original list.
//
//    For example,
//    Given 1->2->3->3->4->4->5, return 1->2->5.
//    Given 1->1->1->2->3, return 2->3.

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 这种基础的链表指针操作题，需要夯实基础把代码写对。
     *
     * 对于判断几个连续相等的节点，想跳过去，同时用东西来控制好流程
     * 要用一个指针pre指在要游动指针的前面
     *
     * 这样游动指针可以尽可能往前走，跳过duplicate elements
     * 然后pre再根据判断自己是不是当时的位置而判断next是谁
     */

}
