package easy;

import java.util.PriorityQueue;

/**
 * Created by eager-mbp on 2017/7/11.
 */
public class ImplementOfstrStr {

//    Implement strStr().
//
//    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                // Find the answer
                if (j == needle.length()) return i;
                // No long enough substring exist
                if (haystack.length() - i < needle.length()) return -1;
                // Pair two string
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
        return -1;
    }

//    public int strStr(String haystack, String needle) {
//        for (int i = 0; ; i++) {
//            for (int j = 0; ; j++) {
//                if (j == needle.length()) return i;
//                if (i + j == haystack.length()) return -1;
//                if (needle.charAt(j) != haystack.charAt(i + j)) break;
//            }
//        }
//    }

    /**
     * 最简单的当然是暴力对比(brute force)
     * 但是大名鼎鼎的KMP看了无数次，这一次是时候自己coding一遍了
     *
     * 虽然KMP自己写了一遍，但标答O(N^2)的解法代码简洁优雅，值得学习
     * 原文里的循环是没有上界条件的的，我自己写了一下，有个j=length()需要加上，要不不能及时退出循环
     * 但标答的第二个判断条件感觉太蛋疼，没看懂，我觉得不能靠这个来结束循环，差评~
     *
     * KMP自己写出来之后还是很开心的，回来也要再次回顾一遍，不要忘记
     * 注释是一个up的标答
     */



    public int[] makeNext(String needle) {
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needle.length()) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        PriorityQueue<Integer> s = new PriorityQueue<>();

        return next;
    }

    public int strKMP(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty()) return 0;
        int[] next = makeNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) return i-j;
            } else {
                if (next[j] == -1) {
                    i++;
                    continue;
                }
                j = next[j];
            }
        }
        return -1;
    }

//    /* P为模式串，下标从0开始 */
//    void GetNext(string P, int next[])
//    {
//        int p_len = P.size();
//        int i = 0;   //P的下标
//        int j = -1;
//        next[0] = -1;
//
//        while (i < p_len)
//        {
//            if (j == -1 || P[i] == P[j])
//            {
//                i++;
//                j++;
//                next[i] = j;
//            }
//            else
//                j = next[j];
//        }
//    }
//
//    /* 在S中找到P第一次出现的位置 */
//    int KMP(string S, string P, int next[])
//    {
//        GetNext(P, next);
//
//        int i = 0;  //S的下标
//        int j = 0;  //P的下标
//        int s_len = S.size();
//        int p_len = P.size();
//
//        while (i < s_len && j < p_len)
//        {
//            if (j == -1 || S[i] == P[j])  //P的第一个字符不匹配或S[i] == P[j]
//            {
//                i++;
//                j++;
//            }
//            else
//                j = next[j];  //当前字符匹配失败，进行跳转
//        }
//
//        if (j == p_len)  //匹配成功
//            return i - j;
//
//        return -1;
//    }
}
