package easy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class MaximumSubarray {

//    Find the contiguous subarray within an array (containing at least one number)
//    which has the largest sum.
//
//    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//    the contiguous subarray [4,-1,2,1] has the largest sum = 6.

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxUntilThis = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxUntilThis = Math.max(nums[i], maxUntilThis + nums[i]);
            res = Math.max(maxUntilThis, res);
        }
        return res;
    }

    /**
     * 关于这道题的DP思想在这里，主要是有了一个想法上的转换：
     * https://discuss.leetcode.com/topic/6413/dp-solution-some-thoughts
     *
     * 事实上，科学家也搞过这个题，是有标准的最优的解法的，dp的过程不用全程tracking，只要记住最大的就行了
     */

//    public int maxSubArray(int[] A) {
//        int n = A.length;
//        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
//        dp[0] = A[0];
//        int max = dp[0];
//
//        for(int i = 1; i < n; i++){
//            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;
//    }
}
