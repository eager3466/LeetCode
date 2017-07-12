package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/9.
 */
public class SumFor4 {

//    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//            Note: The solution set must not contain duplicate quadruplets.
//
//    For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
//    A solution set is:
//            [
//            [-1,  0, 0, 1],
//            [-2, -1, 1, 2],
//            [-2,  0, 0, 2]
//            ]

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3;) {
            int tempTarget = target - nums[i];
            List<List<Integer>> sum3list = threeSum(nums, i+1, tempTarget);
            for (List<Integer> list: sum3list){
                res.add(Arrays.asList(nums[i], list.get(0), list.get(1), list.get(2)));
            }
            while (i < nums.length-4 && nums[i+1] == nums[i]) i++;
            i++;
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int index, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        for(int i=index; i < nums.length-2; ) {
            int low = i+1;
            int high = nums.length-1;
            int sum = target - nums[i];
            while(low < high) {
                if(nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low<high && nums[low+1]==nums[low]) low++;
                    low++;
                    while(high > low && nums[high-1] == nums[high]) high--;
                    high--;
                } else {
                    if(nums[low] + nums[high] < sum) {
                        while(low<high && nums[low+1]==nums[low]) low++;
                        low++;
                    } else {
                        while(high > low && nums[high-1] == nums[high]) high--;
                        high--;
                    }
                }
            }
            while(i<nums.length-3 && nums[i+1]==nums[i]) i++;
            i++;
        }
        return res;
    }

    /**
     * 终于自己独立自主写出来点东西
     * 4sum问题可以复利用3sum的函数来解，3sum是O(n^2)，那么4sum就是O(n^3)
     * 数组排序后，对于从左到右的每一个数，从右边剩下的数中找到3个使得sum=target-nums[i]
     *
     * 复用3sum=0函数对其进行修改：
     * 起始坐标从0变成i+1;
     * 目标之和从0变成target-nums[i]
     *
     * 一开始我还试图每次new一个数组把删除了nums[i]的内容放进去，后来想了想这真的是在浪费时间
     * 更改搜索的起始下标即可
     * 同时3sum里的有些临界条件可以删去
     */

    /**
     * 评论区的答案里有个哥们总结出来了k_sum问题
     * 思路相同，不过对各种情况做了非常好的检查
     * 应当努力记下来
     */

    List<List<Integer>> kSum_Trim(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum_Trim(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if      (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        }
        else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }
}
