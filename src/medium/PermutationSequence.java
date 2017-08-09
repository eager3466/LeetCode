package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/1.
 */
public class PermutationSequence {

//    The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//    By listing and labeling all of the permutations in order,
//    We get the following sequence (ie, for n = 3):
//
//            "123"
//            "132"
//            "213"
//            "231"
//            "312"
//            "321"
//    Given n and k, return the kth permutation sequence.
//    Note: Given n will be between 1 and 9 inclusive.

    public String getPermutation(int n, int k) {
        int factor = 1;
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            factor = factor * i;
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();

        // K-th sequence means res[k-1]
        for (k--; n > 0; n--) {
            factor = factor / n;
            sb.append(nums.remove(k / factor));
            k = k % factor;
        }
        return sb.toString();
    }

    /**
     * 将所有的全排列全部列出，再取第k个，这个方法明显笨拙，但是可行
     * Discuss里的讲解非常详细，对于每一个全排列产生的数量进行精确的数学计算
     * 从而找第k个，非常值得思考和学习
     *
     * 算法已默写，请组织放心。
     */

//    public String getPermutation(int n, int k) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 1; i <= n; i++) list.add(i);
//        int fact = 1;
//        for (int i = 2; i <= n; i++) fact *= i; // factorial
//
//        StringBuilder strBuilder = new StringBuilder();
//        for (k--; n > 0; n--) {
//            fact /= n;
//            strBuilder.append(list.remove(k / fact));
//            k %= fact;
//        }
//
//        return strBuilder.toString();
//    }
}
