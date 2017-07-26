package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/21.
 */
public class CombinationSum {

//    Given a set of candidate numbers (C) (without duplicates) and a target number (T),
//    find all unique combinations in C where the candidate numbers sums to T.
//
//    The same repeated number may be chosen from C unlimited number of times.
//
//            Note:
//    All numbers (including target) will be positive integers.
//    The solution set must not contain duplicate combinations.
//    For example, given candidate set [2, 3, 6, 7] and target 7,
//    A solution set is:
//            [
//            [7],
//            [2, 2, 3]
//            ]

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return res;

        // Every number has 0 times initially.
        int[] times = new int[candidates.length];
        combinationSum(res, candidates, candidates.length, times, target);
        return res;
    }

    private void combinationSum(List<List<Integer>> res, int[] candidates,
                                               int length, int[] times, int target) {
        // Get the proper combination.
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                int n = times[i];
                while (n-- > 0)
                    list.add(candidates[i]);
            }
            res.add(list);
            return ;
        }
        // No numbers to use, just stop the recursive.
        if (length == 0 || target < 0) return ;
        // Max times for the max number.
        int curIndex = length - 1;
        int maxTimes = target / candidates[curIndex];
        for (int i = maxTimes; i >= 0; i--) {
            times[curIndex] = i;
            combinationSum(res, candidates, curIndex, times, target - i * candidates[curIndex]);
        }
    }

    /**
     * 事实证明，把标答里的Arrays.sort(candidates)注释掉，再把 && target >= candidates[i]判断条件去掉，也能AC
     * 因为这个问题其实是不用将原数组排序的
     *
     * 这个题我也按照自己的想法写出来了，但是经过自己的比对之后，看到了两者最根本的差异：
     * 我只是用了递归去遍历每一种可能，而标答的递归是用在了回溯(backtracking)上
     *  ！ 为了父任务和子任务来通讯，表示每一种可能的答案，我用了一个数组来表示，每一个元素使用了多少次
     *  ！ 而回溯，传进去一个ArrayList作为一个可能的答案，然后在最后成功的时候，通过复制构造函数来记录答案，确保没有冲突
     *
     * 我的解法没什么问题，但不好拓展，比如做combinationSum2这道题就会出一些问题，没有办法得知是否需要添加重复的那个数字
     * 而回溯(backtracking)不一样，在元素被排序之后，它能获知同样元素的前一个是否被添加，从而决定本元素是否要添加，来解决重复问题。
     */

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
//
//        return result;
//    }
//
//    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
//        if(target > 0){
//            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
//                cur.add(candidates[i]);
//                getResult(result, cur, candidates, target - candidates[i], i);
//                cur.remove(cur.size() - 1);
//            }//for
//        }//if
//        else if(target == 0 ){
//            result.add(new ArrayList<Integer>(cur));
//        }//else if
//    }
}
