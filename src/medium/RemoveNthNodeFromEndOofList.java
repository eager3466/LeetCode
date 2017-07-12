package medium;

import data.ListNode;

import java.util.Stack;

/**
 * Created by eager-mbp on 2017/7/9.
 */
public class RemoveNthNodeFromEndOofList {

//    Given a linked list, remove the nth node from the end of list and return its head.
//
//    For example,
//
//    Given linked list: 1->2->3->4->5, and n = 2.
//
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
//    Note:
//    Given n will always be valid.
//    Try to do this in one pass.

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)    return null;
        if (n <= 0) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {
            stack.push(p);
            len++;
            p = p.next;
        }
        if (n < len) {
            ListNode delNode = new ListNode(0);
            while (n-- > 0) {
                delNode = stack.pop();
            }
            ListNode preNode = stack.pop();
            // At the beginning, preNode.next = delNode;
            preNode.next = delNode.next;
        } else if (n == len) {
            // Only one element and delete the 1th one.
            if (head.next==null)
                return null;
            else
                head = head.next;
        }
        // when (n > len), we do nothing, just return head
        return head;
    }

    /**
     * 对于删除链表上倒数第n个元素这样的问题，一开始肯定大家都是有共识的
     * 就是两个指针fast和slow，fast先跑n次甩开slow那么多距离
     * 然后两个一起跑，fast到结尾的话slow就到了删除元素的前一个元素了
     *
     * 一开始我没有想到这里，自己用堆栈stack写来着
     * 主要就是一些边界条件，注意点就ok
     *
     * 后来自己也用fast和slow的方法写，其中还是有不少坑的
     * 最主要的就是临界条件，n=1 or len(list)
     * slow作为head之前的指针如何变化
     * 最后得出的结论是，根据fast移动的距离和次数，slow是有可能不走的
     * 所以一开始要记录其位置，做好临界条件的判断即可
     */

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        if (head == null)    return null;
        if (n <= 0) return head;
        ListNode fast = head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        if(fast.next == null)
            return null;
        while(n-- > 0) fast = fast.next;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
