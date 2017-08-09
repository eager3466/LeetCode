package medium;

import data.ListNode;

/**
 * Created by Eager-RESCUER on 2017/8/1.
 */
public class RotateList {

//    Given a list, rotate the list to the right by k places, where k is non-negative.
//
//    For example:
//    Given 1->2->3->4->5->NULL and k = 2,
//            return 4->5->1->2->3->NULL.

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int length = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            length++;
        }
        k = k % length;

        ListNode fpart, lpart;
        lpart = head;
        for(int i = 1; i < length - k; i++){
            head = head.next;
        }

        fpart = head.next;
        head.next = null;

        if(fpart == null) return lpart;
        node = fpart;
        while(node.next != null){
            node = node.next;
        }
        node.next = lpart;

        return fpart;
    }

    /**
     * 有点莫名其妙的题，也不难，还会k>head.length这样的情况出现
     * 这题目是怎么定的，也是醉了，就这样吧
     */
}
