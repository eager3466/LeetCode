package easy;

/**
 * Created by eager-mbp on 2017/7/11.
 */
public class RemoveElement {

//    Given an array and a value, remove all instances of that value in place and return the new length.
//
//    Do not allocate extra space for another array, you must do this in place with constant memory.
//
//    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//    Example:
//    Given input array nums = [3,2,2,3], val = 3
//
//    Your function should return length = 2, with the first two elements of nums being 2.

    public int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[m] = nums[i];
                m++;
            }
        }

        return m;
    }

    /**
     * 即使是如此无聊蛋疼的题，也有很细的解法
     * 通过对相同元素的判断，可以把数组结尾的数拿过来用，这样可以少移动一些元素，少遍历一些
     *
     * 值得思考。
     */

//    int removeElement(int A[], int n, int elem) {
//        int i = 0;
//        while (i < n) {
//            if (A[i] == elem) {
//                A[i] = A[n - 1];
//                n--;
//            }
//            else
//                i++;
//        }
//        return n;
//    }
}
