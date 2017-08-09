package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/6
 */
public class Combinations {

//    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//            For example,
//    If n = 4 and k = 2, a solution is:
//
//            [
//            [2,4],
//            [3,4],
//            [2,3],
//            [1,2],
//            [1,3],
//            [1,4],
//            ]

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<Integer>(), 1,n, k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> subList,
                              int start, int n, int k) {
        if (subList.size() >= k) {
            res.add(new ArrayList<>(subList));
            return ;
        } else {
            for (int i = start; i <= n; i++) {
                subList.add(i);
                backtracking(res, subList, i+1, n, k);
                subList.remove(subList.size()-1);
            }
        }
    }

    /**
     * 还是一如既往的经典的回溯法题
     *
     * 递归：如果数量够了，添加到结果；
     * 如果不够，根据条件添加一个元素，接着回溯，然后再删除掉这个元素
     *
     * 本题的处理重复结果的方法是，只让小的元素在前，大的在后
     * 这样有了[2, 4]后，就不会再添加[4, 2]了
     *
     * 比普通的全排列回溯要加一个参数start，表示从哪个元素开始接着添加元素
     * 而start就是下一轮i的循环起点
     */

//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> combs = new ArrayList<List<Integer>>();
//        combine(combs, new ArrayList<Integer>(), 1, n, k);
//        return combs;
//    }
//    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
//        if(k==0) {
//            combs.add(new ArrayList<Integer>(comb));
//            return;
//        }
//        for(int i=start;i<=n;i++) {
//            comb.add(i);
//            combine(combs, comb, i+1, n, k-1);
//            comb.remove(comb.size()-1);
//        }
//    }
}
