package medium;

/**
 * Created by eager-mbp on 2017/7/19.
 */
public class SearchForARange {

//    Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
//    Your algorithm's runtime complexity must be in the order of O(log n).
//
//    If the target is not found in the array, return [-1, -1].
//
//    For example,
//    Given [5, 7, 7, 8, 8, 10] and target value 8,
//            return [3, 4].

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0)
            return res;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int med = left + ((right - left) >> 1);
            if (nums[med] >= target) {
                right = med;
            } else {
                left = med + 1;
            }
        }
        int start = left;
        if (nums[start] != target) {
            return res;
        }   else {
            res[0] = start;
            while (start < nums.length - 1 && nums[start+1] == nums[start]) start++;
            res[1] = start;
            return res;
        }
    }

    /**
     * 这是一个查找target第一次和最后一次出现位置的二分查找，要用(left < right)
     */

//    int binsearch_last(int * array, int length, int key)
//    {
//        if(!array)
//            return -1;
//        int left = 0, right = length,mid;
//        while(left < right)
//        {
//            mid = left + (right-left)/2;
//            if(array[mid] > key)
//                right = mid - 1;
//            else if(array[mid] == key)
//                if(left == mid)
//                    if(array[right] == key)
//                        return right;
//                    else
//                        return left;
//                else
//                    left = mid;
//            else
//                left = mid + 1;
//        }
//
//        if(array[right] == key)
//            return right;
//        return -1;
//    }
}
