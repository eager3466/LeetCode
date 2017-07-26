package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/21.
 */
public class CombinationSumII {

//    Given a collection of candidate numbers (C) and a target number (T), find all unique
//    combinations in C where the candidate numbers sums to T.
//
//    Each number in C may only be used once in the combination.
//
//    Note:
//    All numbers (including target) will be positive integers.
//    The solution set must not contain duplicate combinations.
//    For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//    A solution set is:
//            [
//            [1, 7],
//            [1, 2, 5],
//            [2, 6],
//            [1, 1, 6]
//            ]

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return res;

        Arrays.sort(candidates);
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
        while (curIndex > 0 && candidates[curIndex] == candidates[curIndex - 1])
            curIndex --;
        int maxTimes = 1;
        for (int i = maxTimes; i >= 0; i--) {
            times[curIndex] = i;
            combinationSum(res, candidates, curIndex, times, target - i * candidates[curIndex]);
        }
    }

    /**
     * 和combinationSum1一样，标答用了backtracking的方法
     * 这里的精髓一点在于，先对元素进行了排序Arrays.sort(cand),在面对相同元素的时候使用了
     *
     * if (i > cur && cand[i] == cand[i-1]) continue;
     *
     * 这是非常非常关键的，比如用1，1，6来构成8，两个1都被添加进来的时候是第一个1先添加，在递归里第二个1添加自己，再找到6来得到8
     * 而第一个1在递归完成后再第二轮的时候，就要跳过相同的元素了，也就是这个continue;
     *
     * DFS的backtracking，需要谨记，在每一次添加一个数字并递归处理后，要将其remove掉
     *
     * path.add(path.size(), cand[i]); 这个骚气的path.size()只是给每次插入的元素加一个索引罢了，实际上就是add
     * （因为默认也会添加到末尾）
     */

//    public List<List<Integer>> combinationSum2(int[] cand, int target) {
//        Arrays.sort(cand);
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> path = new ArrayList<Integer>();
//        dfs_com(cand, 0, target, path, res);
//        return res;
//    }
//    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
//        if (target == 0) {
//            res.add(new ArrayList(path));
//            return ;
//        }
//        if (target < 0) return;
//        for (int i = cur; i < cand.length; i++){
//            if (i > cur && cand[i] == cand[i-1]) continue;
//            path.add(path.size(), cand[i]);
//            dfs_com(cand, i+1, target - cand[i], path, res);
//            path.remove(path.size()-1);
//        }
//    }
}
