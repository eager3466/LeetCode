package hard;

import data.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by eager-mbp on 2017/7/10.
 */
public class MergeKSortedLists {

//    Merge k sorted linked lists and return it as one sorted list.
//    Analyze and describe its complexity.

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        ArrayList<Integer> numsList = new ArrayList<>();
        for (ListNode list: lists) {
            while (list != null) {
                numsList.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(numsList);
        if (numsList.size() == 0) return null;
        ListNode head = new ListNode(numsList.get(0));
        ListNode p = head;
        for (int i = 1; i < numsList.size(); i++) {
            ListNode node = new ListNode(numsList.get(i));
            node.next = null;
            p.next = node;
            p = p.next;
        }
        return head;
    }

    /**
     * 将n个排序的链表整合成一个排序完成的链表。
     * 我是把内容拿下来，排序好，再安上去，用O(n)的空间复杂度，O(nlogn + 2*n)的时间复杂度
     *
     * 答案里有人用优先队列(Priority Queue)来做，往里面使劲add然后poll出来的顺序就是按照comparator比较过的顺序
     *
     * 也有很多人说用递归的思路进行logk次递归调用mergeTwoSortedList()，相当于是一个二分的合并过程
     * 大家乐此不疲的讨论时间复杂度问题，我觉得大概率可能是 n*logk ，但是空间复杂度就高得多了
     * 毕竟二分调用，还有mergeTwoSortedList()，都用了大量的堆栈呐
     */

//    public static ListNode mergeKLists(ListNode[] lists){
//        return partion(lists,0,lists.length-1);
//    }
//
//    public static ListNode partion(ListNode[] lists,int s,int e){
//        if(s==e)  return lists[s];
//        if(s<e){
//            int q=(s+e)/2;
//            ListNode l1=partion(lists,s,q);
//            ListNode l2=partion(lists,q+1,e);
//            return merge(l1,l2);
//        }else
//            return null;
//    }
//
//    //This function is from Merge Two Sorted Lists.
//    public static ListNode merge(ListNode l1,ListNode l2){
//        if(l1==null) return l2;
//        if(l2==null) return l1;
//        if(l1.val<l2.val){
//            l1.next=merge(l1.next,l2);
//            return l1;
//        }else{
//            l2.next=merge(l1,l2.next);
//            return l2;
//        }
//    }
}
