package hard;

import java.util.Stack;

/**
 * Created by Eager-RESCUER on 2017/8/8
 */
public class LargestRectangleInHistogram {

//    Given n non-negative integers representing the histogram's bar height where the
//    width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//    The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//            For example,
//    Given heights = [2,1,5,6,2,3],
//            return 10.

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

    /**
     * 这个题的stack的解法需要多多回味多多复习，非常精髓非常重要，有很多细节点：
     *
     * 1. i的取值范围可以等于len，可以认为是达到了表格最右端的边界，高度为0，意在解决前面最大面积的问题
     * 2.遇到较小的高度值时，先pop，然后用stack.peek()的值来计算width
     * 当中间有高度为0的时候，最后i=len用坐标来计算maxSize，此时i - 1 - stack.peek()直接能定位到前一个坐标为0的index
     * 所以不是说中间有高度为0，最后乘的width就等于i，依旧是i - 1 - stack.peek()
     *
     * 对于线性数组储存法，可以作为发散思维，其实那个构造过程也不是太好想，需要细细琢磨。
     * 但是主要记住这个stack解法好了。
     */

//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length == 0)
//            return 0;
//        int res = 0;
//        int len = heights.length;
//        int[] leftEnd = new int[len];
//        int[] rightEnd = new int[len];
//        leftEnd[0] = -1;
//        rightEnd[len-1] = len;
//        for (int i = 1; i < len; i++) {
//            int p = i - 1;
//            while (p >= 0 && heights[p] >= heights[i]) {
//                p = leftEnd[p];
//            }
//            leftEnd[i] = p;
//        }
//        for (int i = len - 2; i >= 0; i--) {
//            int p = i + 1;
//            while (p < len && heights[p] >= heights[i]) {
//                p = rightEnd[p];
//            }
//            rightEnd[i] = p;
//        }
//        for (int i = 0; i < len; i++) {
//            int size = rightEnd[i] - leftEnd[i] - 1;
//            res = Math.max(res, size * heights[i]);
//        }
//        return res;
//    }

}
