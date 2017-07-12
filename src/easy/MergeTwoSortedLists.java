package easy;

import data.ListNode;

import java.util.List;

/**
 * Created by eager-mbp on 2017/7/10.
 */
public class MergeTwoSortedLists {

//    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
//    the nodes of the first two lists.

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res;
        if (l1.val < l2.val) {
            res = l1;
            merge(l1, l2);
        } else {
            res = l2;
            merge(l2, l1);
        }
        return res;
    }

    public void merge(ListNode small, ListNode big) {
        ListNode p = small;
        ListNode q = big;
        // Node p is smaller than q now
        // Get the proper p.next whose val is bigger than q
        while (p.next != null && p.next.val < q.val) p = p.next;
        if (p.next == null) {
            p.next = q;
            return;
        }
        // temp = q
        // p -> p.next
        // temp -> .... -> q-> q.next
        // p -> temp-> ......-> q -> p.next -> q.next

        ListNode temp = q;
        while (q.next != null && q.next.val < p.next.val) q = q.next;
        if (q.next == null) {
            q.next = p.next;
            p.next = temp;
            return;
        } else {
            ListNode pNode = p.next;
            ListNode qNode = q.next;
            q.next = p.next;
            p.next = temp;
            merge(pNode, qNode);
        }
     }

    /**
     * 我认为这一题自己写的方法比标答要更好
     *
     * 标答的形式更简洁，代码更少，但是递归堆栈调用十分严重，每一个数字都要调用一下
     * 类似于"1->10->11->12" and "2->3->4->5->6->13->14->15"
     * 我在这一点进行了优化，使得每次递归的时候不只是处理一个数字，而是一段可能插入的数字，从而减少了堆栈的调用。
     *
     * 已上传LeetCode ：）
     */

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
}
