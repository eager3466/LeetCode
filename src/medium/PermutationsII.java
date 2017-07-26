package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/25
 */
public class PermutationsII {

//    Given a collection of numbers that might contain duplicates, return all possible
//    unique permutations.
//
//    For example,
//[1,1,2] have the following unique permutations:
//            [
//            [1,1,2],
//            [1,2,1],
//            [2,1,1]
//            ]

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> subList,
                              int[] nums, boolean[] used) {
        if (subList.size() == nums.length) {
            res.add(new ArrayList<>(subList));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            // if i not in subList  (PermutationsI)
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            subList.add(nums[i]);
            used[i] = true;
            backtracking(res, subList, nums, used);
            subList.remove(subList.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 处理带重复元素的全排列，需要加上判断，最核心的一行，还是没有写出来……
     * 相比于没有重复元素的全排列，增加了一个boolean数组used来进行回溯中的通讯
     *
     * used[i-1]和!used[i-1]都可以通过，惊了。
     * 幸好有大神在评论中指点江山，给我解了惑，精髓啊。
     * 总之一句话：避免重复元素带来的重复结果，只要让他们出现任意表现型的时候是固定的下标就行了
     * 也就是（1，2，3）和（3,2,1）的区别
     */

    /**
     * Another explanation for why both

     1. if(i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue;
     and

     2. if(i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;
     work is given below:

     The problem for Permutation II is that different orders of duplicates should only
     be considered as one permutation. In other words, you should make sure that when
     these duplicates are selected, there has to be one fixed order.

     Now take a look at code 1 and 2.

     Code 1 makes sure when duplicates are selected, the order is ascending (index
     from small to large). However, code 2 means the descending order.
     */
}
