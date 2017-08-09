package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/7
 */
public class SubsetsII {

//    Given a collection of integers that might contain duplicates, nums, return all
//    possible subsets.
//
//            Note: The solution set must not contain duplicate subsets.
//
//    For example,
//    If nums = [1,2,2], a solution is:
//
//            [
//            [2],
//            [1],
//            [1,2,2],
//            [2,2],
//            [1,2],
//            []
//            ]

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> subList,
                              int[] nums, int start) {
        res.add(new ArrayList<>(subList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])  continue;
            subList.add(nums[i]);
            backtracking(res, subList, nums, i+1);
            subList.remove(subList.size() - 1);
        }
    }

    /**
     * 相似的思路，同样的backtracking强化练习
     *
     * 学会使用(i > start && nums[i] == nums[i-1])这个判断非常重要
     * 仔细想想其实是 i > start 非常精髓
     *
     * 在这里就必须排序了，因为涉及到去掉重复元素
     * 如果不事先对数组进行排序，那么重复元素并不在一起，会使得无法skip duplicate elements
     */
}
