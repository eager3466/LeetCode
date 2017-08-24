package easy;

public class MergeSortedArray {

//    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//            Note:
//    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
//    additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0)
            return ;
        if (nums2 == null || nums2.length == 0)
            return ;
        while (m-1 >= 0 && n-1 >= 0) {
            if (nums2[n-1] > nums1[m-1]) {
                nums1[m+n-1] = nums2[n-1];
                n--;
            } else {
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
        }
        while (n-1 >= 0) {
            nums1[n-1] = nums2[n-1];
            n--;
        }
    }

    /**
     * 很简单的一题，但是有时候会忘记了nums1里最前面的数字是已经排序好了的
     *
     * 所以在从右往左添加数字的时候，如果nums2消耗殆尽了，就不用管剩下的了，因为一开始就填好了
     * 而nums1消耗殆尽的时候，需要nums2将其剩下的填满，这是自然而然的
     */
}
