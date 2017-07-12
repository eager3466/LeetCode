package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/4.
 */
public class SumFor3 {

//    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
//    Find all unique triplets in the array which gives the sum of zero.
//
//            Note: The solution set must not contain duplicate triplets.
//
//    For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//    A solution set is:
//            [
//            [-1, 0, 1],
//            [-1, -1, 2]
//            ]

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        int i=0, j=nums.length-1;
        Arrays.sort(nums);
        if (nums[i] > 0 || nums[j] < 0)
            return res;
        // All elements are 0
        if (nums[i] == nums[j]) {
            res.add(new ArrayList<Integer>() {{
                add(0);
                add(0);
                add(0);
            }});
            return res;
        }
        int maxNegaIndex = 0;
        int minPosiIndex = nums.length-1;
        // Make maxNegeIndex>=0
        while (nums[maxNegaIndex] < 0 && maxNegaIndex < nums.length-1) maxNegaIndex++;
        // Make minPosiIndex<=0
        while (nums[minPosiIndex] > 0 && minPosiIndex > 0) minPosiIndex--;

        while (i < j && nums[i] < 0) {
            while (j > i && nums[j] > 0) {
                int a = nums[i];
                int c = nums[j];
                int b = 0 - a - c;
                int k;
                if (b>0) {
                    for (k = maxNegaIndex; k < j; k++) {
                        if (b == nums[k]) {
                            res.add(new ArrayList<Integer>() {{
                                add(a);
                                add(b);
                                add(c);
                            }});
                            break;
                        }
                    }
                } else {
                    for (k = minPosiIndex; k > i; k--) {
                        if (b == nums[k]) {
                            res.add(new ArrayList<Integer>() {{
                                add(a);
                                add(b);
                                add(c);
                            }});
                            break;
                        }
                    }
                }
                while (nums[j-1] == nums[j]) j--;
                // Reduce to a index that different to the origin one
                j = j-1;
            }
            while (nums[i+1] == nums[i]) i++;
            i = i + 1;
            // Reset index of j
            j = nums.length-1;
        }
        if (nums[i]==0 && i+2<nums.length && nums[i+2]==0)
            res.add(new ArrayList<Integer>() {{
                add(0);
                add(0);
                add(0);
            }});
        return res;
    }

    /**
     * 讲道理这个题还是有机会做出来的 ，毕竟是一道Medium的题
     *
     * 我的思路是固定住前后俩个数，然后线性查找第三个数是不是在他们中间
     * 这样实际上时间复杂度是O(N^3)，答案的思路是线性循环第一个数，然后双向查找剩下两个数
     * 双向查找的时间复杂度是O(N)，所以总体是O(N^2)，差在了这里
     *
     * 边界条件和剪枝自己做的也还可以，但毕竟选错了思路，就无法pass最后一个考验时间的case。
     */

//    public List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length-2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                if(nums[i]>0) break;
//                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//                        lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) {
//                        // improve: skip duplicates
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        lo++;
//                    } else {
//                        // improve: skip duplicates
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//                        hi--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> threeSumFinal(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        int i=0, j=nums.length-1;
        Arrays.sort(nums);
        if (nums[i] > 0 || nums[j] < 0)
            return res;
        // All elements are 0
        if (nums[i] == nums[j]) {
            res.add(Arrays.asList(0, 0, 0));
            return res;
        }

        for(i=0; i < nums.length-2; ) {
            if(nums[i] > 0) break;
            int low = i+1;
            int high = nums.length-1;
            int sum = 0-nums[i];
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
}
