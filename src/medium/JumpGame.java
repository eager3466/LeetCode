package medium;

/**
 * Created by eager-mbp on 2017/7/27
 */
public class JumpGame {

//    Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//            Determine if you are able to reach the last index.
//
//    For example:
//    A = [2,3,1,1,4], return true.
//
//    A = [3,2,1,0,4], return false.

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int soFarMax = nums[0];
        for (int i = 0; i <= soFarMax; i++) {
            soFarMax = Math.max(soFarMax, i + nums[i]);
            soFarMax = Math.min(soFarMax, nums.length - 1);
        }
        return soFarMax >= nums.length-1;
    }

    /**
     * 贪心算法的一题，用Backtracking和DP的话会增加不必要的时间复杂度
     * 标答有两种，都make sense，我选的是从头到尾的那一种，实质两者都一样
     *
     * 附上从尾到头那种方法的代码
     */

//    public class Solution {
//        public boolean canJump(int[] nums) {
//            int lastPos = nums.length - 1;
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (i + nums[i] >= lastPos) {
//                    lastPos = i;
//                }
//            }
//            return lastPos == 0;
//        }
//    }
}
