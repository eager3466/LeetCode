package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/6
 */
public class Subsets {

//    Given a set of distinct integers, nums, return all possible subsets.
//
//            Note: The solution set must not contain duplicate subsets.
//
//    For example,
//    If nums = [1,2,3], a solution is:
//
//            [
//            [3],
//            [1],
//            [2],
//            [1,2,3],
//            [1,3],
//            [2,3],
//            [1,2],
//            []
//            ]

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int size = 1;
        while (n > 1){
            size = size * n;
            n--;
        }
        backtracking(res, new ArrayList<Integer>(), 1, nums, size);
        return res;
    }

    public void backtracking(List<List<Integer>> res, ArrayList<Integer> subList,
                              int start, int[] nums, int size) {
        if (res.size() >= size) {
            return ;
        } else {
            res.add(new ArrayList<>(subList));
            for (int i = start; i <= nums.length; i++) {
                subList.add(i);
                backtracking(res, subList, i+1, nums, size);
                subList.remove(subList.size()-1);
            }
        }
    }

    /**
     * 作为取字符串中的字符组合的子集，按说backtracking的算法流程应该是一模一样的
     *
     * 只是要想好循环的条件怎么写，还有满足什么情况才加入结果数组
     *
     * 作为所有可能都出现的子集，应该是没有加入结果数组的条件的，我自己瞎写了个少于2^size结果时加入
     * 其实是肯定加入的，只是显得有点多此一举
     *
     * 经过测试，标答里的Arrays.sort(nums)并不是必要的，因为根据题干只要是满足条件的元素就行
     */

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int n = nums.length;
    /**
     * 事实上这个Arrays.sort(nums)并不是必要的
     */
//        Arrays.sort(nums);
//        backtracking(res, new ArrayList<Integer>(), 0, nums);
//        return res;
//    }
//
//
//    public void backtracking(List<List<Integer>> res, ArrayList<Integer> subList,
//                             int start, int[] nums) {
//
//        res.add(new ArrayList<>(subList));
//        for (int i = start; i < nums.length; i++) {
//            subList.add(nums[i]);
//            backtracking(res, subList, i+1, nums);
//            subList.remove(subList.size()-1);
//        }
//    }
}
