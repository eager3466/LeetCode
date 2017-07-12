package easy;

/**
 * Created by eager-mbp on 2017/7/11.
 */
public class RemoveDuplicatesFromSortedArray {
//    Given a sorted array, remove the duplicates in place such that each element appear only once and return
//    the new length.
//
//    Do not allocate extra space for another array, you must do this in place with constant memory.
//
//            For example,
//    Given input array nums = [1,1,2],
//
//    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//    It doesn't matter what you leave beyond the new length.

    public int removeDuplicates(int[] nums) {
        if (nums == null ||  nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int num = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1])
                nums[++num] = nums[i+1];
        }
        return num;
    }

    /**
     * 感觉有点奇怪的一个easy题……叙述多多少少有点问题，点踩的人也挺多，就这样吧没啥说的
     */
}
