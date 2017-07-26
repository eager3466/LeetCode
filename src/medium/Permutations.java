package medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/25
 */
public class Permutations {

//    Given a collection of distinct numbers, return all possible permutations.
//
//            For example,
//[1,2,3] have the following permutations:
//            [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//            ]

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> subList, int[] nums) {
        if (subList.size() == nums.length) {
            res.add(new ArrayList<>(subList));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (subList.contains(nums[i]))  continue;
            subList.add(nums[i]);
            backtracking(res, subList, nums);
            subList.remove(subList.size()-1);
        }
    }

    /**
     * 标准需要理解并记忆的一题：数字全排列
     * 对于不重复数字的全排列，关键在于if (subList.contains(nums[i]))  continue;
     * 这样可以从头到尾循环一遍数字，看看哪个没有加进去，就按顺序加
     *
     * 注意backtracking里的new ArrayList<>()参数
     *
     * 一定要记住！！在最终add的时候，要用复制构造函数再造一个对象添加进去
     * 不然subList这样随处会变动的变量会带来不可估量的错误
     */
}
