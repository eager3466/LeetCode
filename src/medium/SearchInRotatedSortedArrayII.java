package medium;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

import javax.management.openmbean.TabularType;

/**
 * Created by Eager-RESCUER on 2017/8/7
 */
public class SearchInRotatedSortedArrayII {

//    Follow up for "Search in Rotated Sorted Array":
//    What if duplicates are allowed?
//
//    Would this affect the run-time complexity? How and why?
//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//            (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//    Write a function to determine if a given target is in the array.
//
//    The array may contain duplicates.

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            // left is sorted
            if (nums[mid] > nums[low] || nums[mid] > nums[high]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                high--;
            }
        }
        return false;
    }

    /**
     * 在有重复元素的情况下，这个2题就比1题多出来了一些额外的判断
     *
     * 因为nums[low]和nums[high]可能相等
     * 所以判断的时候要用(nums[mid] > nums[low] || nums[mid] > nums[high])
     *
     * 除此之外，如果都相等，存在重复元素，则令high--以消除重复
     */

//    public boolean search(int[] nums, int target) {
//        int start = 0, end = nums.length - 1, mid = -1;
//        while(start <= end) {
//            mid = (start + end) / 2;
//            if (nums[mid] == target) {
//                return true;
//            }
//            //If we know for sure right side is sorted or left side is unsorted
//            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
//                if (target > nums[mid] && target <= nums[end]) {
//                    start = mid + 1;
//                } else {
//                    end = mid - 1;
//                }
//                //If we know for sure left side is sorted or right side is unsorted
//            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
//                if (target < nums[mid] && target >= nums[start]) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
//                //any of the two sides won't change the result but can help remove duplicate from
//                //consideration, here we just use end-- but left++ works too
//            } else {
//                end--;
//            }
//        }
//
//        return false;
//    }
}
