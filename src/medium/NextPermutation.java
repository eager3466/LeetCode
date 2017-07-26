package medium;

/**
 * Created by eager-mbp on 2017/7/17.
 */
public class NextPermutation {

//    Implement next permutation, which rearranges numbers into the lexicographically next greater
//    permutation of numbers.
//
//    If such arrangement is not possible, it must rearrange it as the lowest possible order
//    (ie, sorted in ascending order).
//
//    The replacement must be in-place, do not allocate extra memory.
//
//    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
//    in the right-hand column.
//            1,2,3 → 1,3,2
//            3,2,1 → 1,2,3
//            1,1,5 → 1,5,1

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return ;
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                int j = (i == nums.length-1) ? i : i+1;
                while (j < nums.length-1 && nums[j] > nums[i-1])  j++;
                int k = (nums[j] > nums[i-1]) ? j : j-1;
                // swap (nums[i-1], nums[k])
                int temp = nums[i-1];
                nums[i-1] = nums[k];
                nums[k]  = temp;
                reverse(nums, i, nums.length - 1);
                return ;
            }
        }
        if (i == 0)
            reverse(nums, i, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (j > i) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }

    /**
     * 没太多好说的，这是一道数学家们搞出来过算法的题，属于看了就要将其记住的题
     * https://leetcode.com/problems/next-permutation/#/solution 里面讲的非常清楚了
     * 即使是固定的算法，短时间内也难以比标答写得简洁易读，需要多多学习
     *
     * 比如对于j的寻找方法，我是从i后面依次递增来找j
     * 而标答是从length()-1处依次减小来寻找，这样减少了一些冗余的地方
     */

//    public void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i + 1] <= nums[i]) {
//            i--;
//        }
//        if (i >= 0) {
//            int j = nums.length - 1;
//            while (j >= 0 && nums[j] <= nums[i]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
//        reverse(nums, i + 1);
//    }
//
//    private void reverse(int[] nums, int start) {
//        int i = start, j = nums.length - 1;
//        while (i < j) {
//            swap(nums, i, j);
//            i++;
//            j--;
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
