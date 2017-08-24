package medium;

import java.util.Stack;

/**
 * Created by eager-mbp on 2017/8/15.
 */
public class MaximalRectangle {

//    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
//    containing only 1's and return its area.
//
//    For example, given the following matrix:
//
//            1 0 1 0 0
//            1 0 1 1 1
//            1 1 1 1 1
//            1 0 0 1 0
//    Return 6.

    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxSize;
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = (i == 0) ? 1 : heights[i-1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < heights.length; i++)
            maxSize = Math.max(maxSize, largestRectangleArea(heights[i]));
        return maxSize;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int maxSize = 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            // 这点非常精髓，让i可以等于len，但是高度等于0，也就是说要把之前所有的最大面积要收一下计算出来
            int h = (i == len) ? 0 : heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                // means stack is notEmpty and height[i] < heights[stack.peek()]
                int topIndex = stack.pop();
                maxSize = Math.max(maxSize,
                        (stack.isEmpty()? i : i - 1 - stack.peek()) * heights[topIndex]);
                i--;
            }
        }
        return maxSize;
    }
}
