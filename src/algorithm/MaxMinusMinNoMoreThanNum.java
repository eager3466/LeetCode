package algorithm;

import java.util.LinkedList;

/**
 * Created by eager-mbp on 2018/10/5.
 */
public class MaxMinusMinNoMoreThanNum {

    /**
     * 题目：
     *
     * 给定数组 arr 和整数 num, 共返回有多少个⼦数组满⾜如下情况:
     * max(arr[i...j]) - min(arr[i...j]) <= num
     * max(arr[i...j])表示⼦数组 arr[i...j]中的最⼤值,min(arr[i...j])表示⼦数组arr[i...j]中的最小值。
     */

    // 解题思路：使用两个双端队列qMax和qMin来维护，使得时间复杂度为O(n)
    // ps: 一个元素也算子数组{2} max - min = 0 < 4(num)
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,8,9,1,3,5,4,6};
        int num = 4;
        System.out.print(noMoreThanNum(arr, num));
    }

    private static int noMoreThanNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]) {
                    qMax.pollLast();
                }
                qMax.add(j);
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]) {
                    qMin.pollLast();
                }
                qMin.add(j);
                if (arr[qMax.getFirst()] - arr[qMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }
            System.out.println("from " + i + "to " + j + ", total: " + (j - i));
            res += j - i;
            i++;
        }

        return res;
    }
}
