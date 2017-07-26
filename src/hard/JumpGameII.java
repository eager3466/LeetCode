package hard;

/**
 * Created by eager-mbp on 2017/7/24.
 */
public class JumpGameII {

//    Given an array of non-negative integers, you are initially positioned at the first
//    index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//    Your goal is to reach the last index in the minimum number of jumps.
//
//    For example:
//    Given array A = [2,3,1,1,4]
//
//    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
//    then 3 steps to the last index.)
//
//    Note:
//    You can assume that you can always reach the last index.

    public int jump(int[] nums) {

        int jump = 0;
        int last_max = 0;
        int cur_max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur_max = Math.max(cur_max, i + nums[i]);
            if (i == last_max) {
                last_max = cur_max;
                jump ++;
            }
        }
        return jump;
    }

    /**
     * 我把这个题用DP写出来了，但是最后一个case都是1，导致StackOverflowException
     * 特此保存一下，上面的代码是重写了一遍的标答。
     *
     * 标答的思想非常巧妙，因为这个题应该会比实际上想象的简单，毕竟可以跳n或者n内的任意一步
     * 正如http://www.allenlipeng47.com/blog/index.php/2016/09/12/jump-game-ii/里将的算法一样
     *
     * 对于每一jump，都能预知这个jump最差和最远能达到的范围
     * 每到一次跳的范围的极限，就给计数器加一次
     *
     * 因为题干表示always reach，所以题目总是有解。
     */

//    int res = Integer.MAX_VALUE;
//
//    public int jump(int[] nums) {
//        if (nums == null || nums.length <=1)
//            return 0;
//        jump(nums, 0, 0);
//        return res;
//    }
//
//    private boolean jump(int[] nums, int start, int curStep) {
//        if (nums[start] == 0) return false;
//        if (nums[start] >= nums.length - 1 - start) {
//            curStep += 1;
//            res = curStep < res ? curStep : res;
//            return true;
//        } else {
//            for (int i = nums[start]; i >= 1; i--) {
//                if (jump(nums, start + i, curStep + 1))
//                    return true;
//            }
//        }
//        return false;
//    }
}
