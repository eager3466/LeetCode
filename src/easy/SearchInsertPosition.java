package easy;

/**
 * Created by eager-mbp on 2017/7/20.
 */
public class SearchInsertPosition {

//    Given a sorted array and a target value, return the index if the target is found. If not, return the index where
//    it would be if it were inserted in order.
//
//    You may assume no duplicates in the array.
//
//    Here are few examples.
//            [1,3,5,6], 5 → 2
//            [1,3,5,6], 2 → 1
//            [1,3,5,6], 7 → 4
//            [1,3,5,6], 0 → 0

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums[0] >= target) return 0;
        if (nums[nums.length-1] < target) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target){
                if (mid == left) {
                    // means right = left + 1;
                    if(nums[right] >= target) return right;
                }
                left = mid;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     * 题目的意思是找到"第一个大于等于target的数的下标"，那外层循环还是用(left <= right)会容易许多
     *
     * 二分查找看了许多，要找"第一个该数字出现的位置"的时候要用(left < right)，我大致是用了这个思路
     * 虽然也是AC了，但因为没有正确高效地理解题意导致写得并不简洁，这其实不太好。
     */

//    public int searchInsert(int[] A, int target) {
//        int low = 0, high = A.length-1;
//        while(low<=high){
//            int mid = (low+high)/2;
//            if(A[mid] == target) return mid;
//            else if(A[mid] > target) high = mid-1;
//            else low = mid+1;
//        }
//        return low;
//    }
}
