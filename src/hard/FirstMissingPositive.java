package hard;

/**
 * Created by eager-mbp on 2017/7/21.
 */
public class FirstMissingPositive {

//    Given an unsorted integer array, find the first missing positive integer.
//
//    For example,
//    Given [1,2,0] return 3,
//    and [3,4,-1,1] return 2.
//
//    Your algorithm should run in O(n) time and uses constant space.

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 这个题挺有意思，解题的思路也非常有趣，不过，如何在O(n)的时间复杂度和O(1)的空间复杂度下实现，
     * 我没有想出来，看了标答才颇有感悟，类似于半自动排序的方法，把每个数字放到指定的位置，从而确定结果
     * swap的时候，不要直接操作nums[i] 和 nums[nums[i] - 1]，容易使数组元素变化从而交换失败
     * 还是用下标来换比较靠谱
     */

//    class Solution
//    {
//        public:
//        int firstMissingPositive(int A[], int n)
//        {
//            for(int i = 0; i < n; ++ i)
//                while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
//                    swap(A[i], A[A[i] - 1]);
//
//            for(int i = 0; i < n; ++ i)
//                if(A[i] != i + 1)
//                    return i + 1;
//
//            return n + 1;
//        }
//    };
}
