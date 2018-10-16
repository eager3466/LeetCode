package algorithm;

import java.util.Stack;

/**
 * Created by eager-mbp on 2018/10/3.
 */
public class MaxRecSize {

    public static void main(String[] args) {
        int[][] map = new int[][]{
                        {1,0,1,1,0,1,0},
                        {1,1,1,1,1,1,1},
                        {1,1,1,0,1,1,0}
                        };
        System.out.print("" + maxRecSize(map));
    }

    private static int maxRecSize(int[][] map){
        if (map == null || map.length == 0)
            return 0;
        int layer = map.length;
        int number = map[0].length;
        int height[][] = new int[layer][number];
        int max = 0;
        for (int i = 0; i < layer; i++) {
            for (int j = 0; j < number; j++) {
                height[i][j] = map[i][j] == 1 ? 1 : 0;
                if (i >= 1 && height[i][j] != 0) {
                    height[i][j] += height[i-1][j];
                }
            }
            max = Math.max(max, getMaxRect(height[i]));
        }
        return max;
    }

    private static int getMaxRect(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            // 把push操作放到后面，便于代码处理
//            if (stack.isEmpty()) {
//
//            } else {
//                // 注意这里等于的时候不压栈，只有大于时候压
//                // 相当于等于的时候只有下标在走，计算的面积不断增大
//                if (arr[i] > arr[stack.peek()]) {
//                    stack.push(i);
//                } else {
//
//                }
//            }

            // 找到了比栈顶小的元素，栈顶弹出，同时计算当前矩形大小
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int top = stack.pop();
                int pre = stack.isEmpty() ? -1 : stack.peek();
                int size = arr[top] * (i - pre - 1);
                max = Math.max(max, size);
            }
            stack.push(i);
        }
        // 最后一个元素的处理
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int pre = stack.isEmpty() ? -1 : stack.peek();
            int size = arr[top] * (arr.length - pre - 1);
            max = Math.max(max, size);
        }
        return max;
    }
}
