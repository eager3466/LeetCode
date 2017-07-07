package medium;

/**
 * Created by eager-mbp on 2017/6/18.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null && l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;

        int startSum = l1.val + l2.val;
        ListNode res = new ListNode(startSum%10);
        ListNode head = res;
        int add = startSum / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            ListNode mid = new ListNode(sum%10);
            add = sum / 10;
            res.next = mid;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (add >= 1) {
                res.next = new ListNode(1);
            }
        } else {
            if (l1 == null)
                res.next = addNumberToNode(add, l2);
            if (l2 == null)
                res.next = addNumberToNode(add, l1);
        }
        return head;
    }

    private ListNode addNumberToNode(int num, ListNode node) {
        int sum = num + node.val;
        node.val = sum % 10;
        ListNode p = node;
        while (sum == 10) {
            if(p.next == null) {
                p.next = new ListNode(1);
                sum = 0;
                p.val = 0;
            } else {
                p.val = 0;
                p = p.next;
                sum = p.val + 1;
            }
        }
        p.val = sum % 10;
        return node;
    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 官方解法 Editorial Solution
     */

    /**
     *
     *
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummyHead = new ListNode(0);
         ListNode p = l1, q = l2, curr = dummyHead;
         int carry = 0;
         while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
             int sum = carry + x + y;
             carry = sum / 10;
             curr.next = new ListNode(sum % 10);
             curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
         }
         if (carry > 0) {
            curr.next = new ListNode(carry);
         }
         return dummyHead.next;
     }
     */

    /**
     * notes：
     * 比起官方解法，我主要是着重于：有对应位的地方加完之后，想直接把下面的链表接在当前结果的末尾上，
     * 但这样要处理最后一个数和一个链表的相加，就出现了自己的还专门造一个的函数，这样其实效率很低下。
     *
     * 官方解法把这两者合二为一，虽然你位数没有了，但是可以当做你的值为0啊，这样的简单处理就使得整
     * 个代码简洁统一，便于阅读。
     */
}
