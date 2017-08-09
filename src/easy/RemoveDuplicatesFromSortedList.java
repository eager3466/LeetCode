package easy;

import data.ListNode;

/**
 * Created by Eager-RESCUER on 2017/8/8
 */
public class RemoveDuplicatesFromSortedList {

//    Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//    For example,
//    Given 1->1->2, return 1->2.
//    Given 1->1->2->3->3, return 1->2->3.

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode cur = head;
        while (cur != null) {
            ListNode p = cur.next;
            if (p != null) {
                if (p.val == cur.val) {
                    while (p.next != null && p.next.val == p.val)
                        p = p.next;
                }
                cur.next = p.next;
                cur = p.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 这样的题，写肯定是能写出来，但是总是考虑不够精简，估计是时间不太够
     *
     * 看了标答的简洁写法也非常服气，毕竟人家循环条件写得好
     *
     * 实质上是抓住了这道题的核心：(current != null && current.next != null) 才会有所谓的比较和指针前进
     * 所以只以一个指针非空为循环条件肯定是代码会冗余不少
     *
     * 不过多给自己一点时间，应该能把代码再合并一下，写得更好看的
     */

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        while (current != null && current.next != null) {
//            if (current.next.val == current.val) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }
//        return head;
//    }
}
