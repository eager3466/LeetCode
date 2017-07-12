package hard;

import data.ListNode;

import java.util.Stack;

/**
 * Created by eager-mbp on 2017/7/11.
 */
public class ReverseNodesInKGroup {

//    Given a linked list, reverse the nodes of a linked list k at a time and return its modified
//    list.
//
//    k is a positive integer and is less than or equal to the length of the linked list.
//    If the number of nodes is not a multiple of k then left-out nodes in the end should
//    remain as it is.
//
//    You may not alter the values in the nodes, only nodes itself may be changed.
//
//    Only constant memory is allowed.
//
//    For example,
//
//    Given this linked list: 1->2->3->4->5
//
//    For k = 2, you should return: 2->1->4->3->5
//
//    For k = 3, you should return: 3->2->1->4->5

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;
        ListNode m = head;
        // To confirm enough nodes to inverse.
        while (--k > 0) {
            m = m.next;
            if (m == null)
                return head;
        }
        // reverse head -> .... -> m
        // m is the last node of a reversal
        ListNode p = head;
        ListNode q = m.next;
        Stack<ListNode> stack = new Stack<>();
        // Push k elements into stack
        while (p != q) {
            stack.push(p);
            p = p.next;
        }
        ListNode node = stack.pop();
        ListNode newHead = node;
        ListNode next = new ListNode(0);
        node.next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            node.next = next;
            node = next;
        }
        next.next = reverseKGroup(q, k);
        return newHead;
    }

    /**
     * 一道反转指定长度（k个）链表的题，每k个反转一次，不到k个则不反转
     * 一开始我自己的思路是，在处理完当前的k个节点后，再递归下一轮
     * 所以自己就无法完成反转的这个动作，不得不借助于一个stack，这样就造成了浪费，降低了效率
     *
     * 而标答有所改动而且非常精髓的地方就是，它是先递归得到后置位的头节点，再将其作为tail来反转当前这一轮节点
     * ListNode tail = reverseKGroupAns(cur,k); 先进行这个递归操作，是非常非常重要的，需要记下来。
     */

//    public ListNode reverseKGroupAns(ListNode head, int k) {
//        int len = 0;
//        ListNode cur = head;
//        while (cur!=null && len<k){
//            cur = cur.next;
//            len++;
//        }
//        if (len!=k){
//            return head;
//        }
//        else{
//            ListNode tail = reverseKGroupAns(cur,k);
//            cur = head;
//            for (int i=0;i<k;i++){
//                ListNode tmp = cur.next;
//                cur.next = tail;
//                tail = cur;
//                cur = tmp;
//            }
//            cur = tail;
//        }
//        return cur;
//    }

    public ListNode reverseKGroupRewrite(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;
        ListNode m = head;
        // To confirm enough nodes to inverse.
        int num = k;
        while (--num > 0) {
            m = m.next;
            if (m == null)
                return head;
        }
        // reverse head -> .... -> m
        // m is the last node of a reversal
        ListNode p = head;
        ListNode q = reverseKGroupRewrite(m.next, k);
        for (int i=0; i<k; i++) {
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }
        return q;
    }
}
