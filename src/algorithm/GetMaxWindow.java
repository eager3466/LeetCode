package algorithm;

import java.util.LinkedList;

/**
 * Created by eager-mbp on 2018/10/2.
 */
public class GetMaxWindow {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,6,4,3,7,8,5,34,3,1,3,25,4,2};
        int w = 3;
        int[] res = getMaxWindow(a, w);
        for (int i : res) {
            System.out.print(" " + i);
        }
    }

    private static int[] getMaxWindow(Integer[] arr, int w) {
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty()) {
                queue.add(i);
            } else {
                while (!queue.isEmpty() && arr[queue.getLast()] <= arr[i]) {
                    queue.removeLast();
                }
                queue.add(i);
            }
            if (!queue.isEmpty()) {
                while (queue.peekFirst() == i - w) {
                    queue.removeFirst();
                }
            }
            if (!queue.isEmpty() && index < arr.length - w + 1 && i >= w - 1) {
                res[index++] = arr[queue.getFirst()];
            }
        }
        return res;
    }
}
