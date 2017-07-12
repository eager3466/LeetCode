package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/7.
 */
public class Closest3Sum {

//    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    public int threeSumClosest(int[] nums, int target) {
        // Exception
        if (nums == null || nums.length < 3)
            return 0;
        if (nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        int distance = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int i=0, j=nums.length-1;
        while(i < nums.length-2) {
            int low = i+1;
            int high = nums.length-1;
            int sum = target-nums[i];
            while(low < high) {
                if(nums[low] + nums[high] == sum) {
                    return target;
                } else {
                    if (Math.abs(nums[low] + nums[high] - sum) < distance) {
                        res = nums[i] + nums[low] + nums[high];
                        distance = Math.abs(nums[low] + nums[high] - sum);
                    }
                    if(nums[low] + nums[high] < sum) {
                        while(low<high && nums[low+1]==nums[low]) low++;
                        low++;
                    } else {
                        while(high > low && nums[high-1] == nums[high]) high--;
                        high--;
                    }
                }
            }
            while(i<nums.length-3 && nums[i+1]==nums[i]) i++;
            i++;
        }
        return res;
    }

    /**
     * 没什么好说的，可以用上一题的思路来搞，循环，然后记录最小距离，输出结果。
     * 注意多处可以优化的地方即可。
     */
}
