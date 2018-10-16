package sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eager-mbp on 2018/9/3.
 */
public class QuickSort extends Sort<Integer>{

    private Integer a[] = new Integer[]{3,2,6,74,21,4,98,6,7,70,31,56,28};

    private void quickSort(Integer[] a, int l, int h) {

        if (l >= h) {
            return;
        }
        int m = getPartition(a, l, h);
        quickSort(a, l, m - 1);
        quickSort(a, m + 1, h);
        Queue<String> q = new LinkedList<>();
    }

    private int getPartition(Integer[] a, int low, int high) {

        int value = a[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (less(a[i], value) && i != high) i++;
            while (less(value, a[j]) && j != low ) j--;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public void printResult() {
        for (Integer i : a) {
            System.out.print(i);
            System.out.print(' ');
        }

    }

    @Override
    public QuickSort sort() {
        quickSort(a, 0, a.length - 1);
        return this;
    }
}
