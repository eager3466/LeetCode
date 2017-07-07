package easy;

/**
 * Created by eager-mbp on 2017/6/27.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) {
            return res;
        }

        for (int i=nums.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (nums[i]+nums[j] == target) {
                    res[0] = j;
                    res[1] = i;
                    break;
                }
            }
        }
        return res;
    }
}
