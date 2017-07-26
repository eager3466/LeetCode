package medium;

/**
 * Created by eager-mbp on 2017/7/19.
 */
public class SearchInRotatedSortedArray {

//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//            (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//    You may assume no duplicate exists in the array.

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int med = (low + high) / 2;
            if (nums[med] > nums[high]) {
                low = med + 1;
            } else {
                high = med;
            }
        }
        // Thus, low == high means the smallest one after rotation.
        int rot = low;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        if (target > nums[nums.length - 1])  {
            low = 0;
            high = rot - 1;
        } else {
            low = rot;
            high = nums.length - 1;
        }
        while (low <= high && low <= nums.length-1 && high >= 0) {
            int med = (low + high) / 2;
            if (nums[med] == target) return med;
            if (nums[med] > target) high = med - 1;
            else low = med + 1;
        }
        return -1;
    }
}
