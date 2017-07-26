package hard;

/**
 * Created by eager-mbp on 2017/7/24.
 */
public class TrappingRainWater {

//    Given n non-negative integers representing an elevation map where the width of each bar is 1,
//    compute how much water it is able to trap after raining.
//
//            For example,
//    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//
//
//    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of
//    rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int res = 0;
        // [1, len()-2]
        for (int i = 1; i < height.length - 1; ) {
            int j = i - 1;
            int k = i + 1;
            // Invalid position
            if (height[j] < height[i] || height[k] < height[i]) {
                i = k;
                continue;
            }
            // Here (height[j] >= height[i] && height[k] >= height[i])
            while (j - 1 >= 0 && height[j-1] >= height[j])  j--;
            while ((k + 1 <= (height.length-1)) && height[k + 1] >= height[k])  k++;
            int localTop = Math.min(height[j], height[k]);
            if (height[k] == height[i+1] && height[j] == height[i-1]) {
                res += localTop - height[i];
            } else {
                for (int m = j; m <= k; m++) {
                    res += (height[m] >= localTop) ? 0 : localTop - height[m];
                }
            }
            i = k + 1;
        }
        return res;
    }

    /**
     * 这个题自己想用一种看起来简单的方式实现。但是不幸，挂掉了，用了O(n^2)的时间复杂度还没有搞定问题
     * 事实上O(n^2)可以用最笨的方法求解，而我也没有用好。
     * https://leetcode.com/articles/trapping-rain-water/ 的第二种方法是应该努力以后要想起来的方法
     *
     * 这个方法的主要特点在于，每个位置的left_max和right_max是可以和左右相互关联的
     * 也就可以动态记录并变更，用两个数组将其存下来之后，就可以求得任一位置的存水量（本身是最高点则不存）
     * Time complexity: O(n) && Space complexity: O(n)
     */

//    int trap(vector<int>& height)
//    {
//        if(height == null)
//            return 0;
//        int ans = 0;
//        int size = height.size();
//        vector<int> left_max(size), right_max(size);
//        left_max[0] = height[0];
//        for (int i = 1; i < size; i++) {
//            left_max[i] = max(height[i], left_max[i - 1]);
//        }
//        right_max[size - 1] = height[size - 1];
//        for (int i = size - 2; i >= 0; i--) {
//            right_max[i] = max(height[i], right_max[i + 1]);
//        }
//        for (int i = 1; i < size - 1; i++) {
//            ans += min(left_max[i], right_max[i]) - height[i];
//        }
//        return ans;
//    }

    /**
     * 重写优化后的Two Pointer算法，一次循环可以搞定
     */

    public int trapRetry(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    res += left_max - height[left];
                    left++;
                }
            } else {
                if (height[right] < right_max) {
                    right_max = height[right];
                } else {
                    res += right_max - height[right];
                    right++;
                }
            }
        }
        return res;
    }

    /**
     * 附：第三种的堆栈算法也相当精妙！虽然空间复杂度比双指针算法高一些达到了O(n)，但是思路很好
     * 利用了栈来使得每一个可以存水的地方，都用阶梯形式的一层一层的来计算
     *
     * 这个计算是，找到存水地的右边缘从而计算的，所以非常严谨，绝对不会出错。
     */

//    int trap(vector<int>& height)
//    {
//        int ans = 0, current = 0;
//        stack<int> st;
//        while (current < height.size()) {
//            while (!st.empty() && height[current] > height[st.top()]) {
//                int top = st.top();
//                st.pop();
//                if (st.empty())
//                    break;
//                int distance = current - st.top() - 1;
//                int bounded_height = min(height[current], height[st.top()]) - height[top];
//                ans += distance * bounded_height;
//            }
//            st.push(current++);
//        }
//        return ans;
//    }
}
