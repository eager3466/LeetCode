package medium;

/**
 * Created by Eager-RESCUER on 2017/8/5
 */
public class SortColors {

//    Given an array with n objects colored red, white or blue, sort them so that
//    objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//            Note:
//    You are not suppose to use the library's sort function for this problem.
//
//    click to show follow up.

    public void sortColors(int[] nums) {
        if (nums == null)
            return ;
        int left = 0;
        int right = nums.length-1;
        for (int i = 0; i < right; i++) {
            if (nums[i] == 0 && i != left) {
                swap(nums, left++, i--);
            } else if(nums[i] == 2 && i != right) {
                swap(nums, right--, i--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 这应该算是一道非常经典的排序题了，三色旗问题
     *
     * 经典做法就是两端有两个指针，都往中间走，用一个游标依次遍历数组
     * 遇到0就和左边的指针换，遇到2就和右边的指针换
     *
     * 注意指针下标的计算即可
     */

//    class Solution {
//        public:
//        void sortColors(int A[], int n) {
//            int second=n-1, zero=0;
//            for (int i=0; i<=second; i++) {
//                while (A[i]==2 && i<second) swap(A[i], A[second--]);
//                while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
//            }
//        }
//    };
}
