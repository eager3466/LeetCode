package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eager-mbp on 2017/7/13.
 */
public class MinimumWindowSubstring {

//    Given a string S and a string T, find the minimum window in S which will contain all the characters in T
//    in complexity O(n).
//
//    For example,
//            S = "ADOBECODEBANC"
//    T = "ABC"
//    Minimum window is "BANC".
//
//    Note:
//    If there is no such window in S that covers all characters in T, return the empty string "".
//
//    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

    public String minWindow(String s, String t) {
        if (s == null || t == null) return null;
        if (t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.keySet().contains(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
        }
        String res = "";
        String minCmp = s;
        // The already-paired number in t.
        int count = 0;
        int left  = 0;
        int right = 0;
        while (right < s.length()) {
            char chRight = s.charAt(right);
            if (map.keySet().contains(chRight)) {
                if (map.get(chRight) > 0) {
                    count++;
                }
                map.put(chRight, map.get(chRight) - 1);
            }
            right ++;
            while (count == t.length()) {
                // Shrink left to get minimum window size
                if (left < right) {
                    // Record result [i, j)
                    String temp = s.substring(left, right);
                    if (temp.length() <= minCmp.length()) {
                        minCmp = temp;
                        res = minCmp;
                    }
                }
                char chLeft = s.charAt(left);
                if (map.keySet().contains(chLeft)) {
                    map.put(chLeft, map.get(chLeft) + 1);
                    if (map.get(chLeft) > 0)   count --;
                }
                left ++;
            }
        }
        return res;
    }

    /**
     * 非常棒的一道题了，而且网上也找到了类似题目的解题模板
     * https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/13
     * 类似的题就要有这样的解题思路，一定要铭记在心
     *
     * 此处摘录的答案是一个比较标准的java解法
     * 即使是统一的模板，也有code可以做到优雅简洁，比如：
     * map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
     *
     * 而且模板里有一个思路很重要，就是下标是不断增加的，但是不超过数组上线
     * 我自己做的时候思路是把下标控制好，然后取substring，这其实就有很多矛盾且不好处理的地方，一方面right需要
     * 向前走，另一方面又不能越界，但是又要进行最后一次循环，还要作为substring的第二个参数，非常惨淡
     *
     * 最后看到的方法还是通过坐标来计算长度，再最后统一调用substring，确实能涵盖所有的边界条件了
     */

//    public static String minWindow(String s, String t) {
//        Map<Character, Integer> map = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        int minStart = 0, minEnd = 0;
//        int count = t.length();
//        for (char c : t.toCharArray()) {
//            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
//        }
//        int left = 0;
//        for (int right = 0; right < s.length(); right++) {
//            char val = s.charAt(right);
//            if (map.containsKey(val)) {
//                map.put(val, map.get(val) - 1);
//                if (map.get(val) >= 0) {
//                    count--;
//                }
//            }
//            while (count == 0) {
//                if (right - left < min) {
//                    min = right - left;
//                    minStart = left;
//                    minEnd = right;
//                }
//                char temp = s.charAt(left);
//                if (map.containsKey(temp)) {
//                    map.put(temp, map.get(temp) + 1);
//                    if (map.get(temp) > 0) count++;
//                }
//                left++;
//            }
//        }
//        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
//    }
}
