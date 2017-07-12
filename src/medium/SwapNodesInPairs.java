package medium;

import data.ListNode;

/**
 * Created by eager-mbp on 2017/7/11.
 */
public class SwapNodesInPairs {

//    Given a linked list, swap every two adjacent nodes and return its head.
//
//    For example,
//    Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//    Your algorithm should use only constant space. You may not modify the values in the list,
//    only nodes itself can be changed.



    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // Swap head and head.next
        // Save head.next and head.next.next
        ListNode p = head.next;
        ListNode q = head.next.next;
        head.next = swapPairs(q);
        p.next = head;
        return p;
    }

    /**
     * 还算简单的一题，一遍过了，不过按说用了递归的话，额外的空间调用是堆栈的
     * 就不是连续的了，略微不太符合题意
     *
     * 答案里有人提到的顺序遍历，也是不难，这里主要看到了dummy节点的应用，它通常在链表题里用来指向head
     * 处理一些空指针问题
     */

// DUMMY node
//  " A dummy node is often used in linked list questions in order to avoid
// a special case at the beginning of the list. In this case, without the dummy,
// the loop would start with prev set as null.
// This just saved him a null check."

    // pre->cur->suc->tmp ==> pre->suc->cur->tmp ==> pre->suc->cur(pre)->tmp
//    public ListNode swapPairs(ListNode head) {
//        ListNode dmy = new ListNode(0), pre = dmy;
//        dmy.next = head;
//        while (pre.next != null && pre.next.next != null) {
//            ListNode cur = pre.next, suc = cur.next, tmp = suc.next;
//            pre.next = suc;
//            suc.next = cur;
//            cur.next = tmp;
//            pre = cur;
//        }
//        return dmy.next;
//    }
}
