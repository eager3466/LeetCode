package hard;

import java.util.Stack;

/**
 * Created by eager-mbp on 2017/7/17.
 */
public class LongestValidParentheses {

//    Given a string containing just the characters '(' and ')', find the length of the longest
//    valid (well-formed) parentheses substring.
//
//    For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//    Another example is ")()())", where the longest valid parentheses substring is "()()", which
//    has length = 4.

    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

    /**
     * 这个题没什么好说的，答案写的非常详尽也非常精髓，有三种方法：DP，stack，two pointer
     * 自己手动写了两种，觉得DP算法里的这两行不是太好写的简洁优雅，需要非常花脑子去想，这是一个提高点。
     * if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + ((i - dp[i-1] >=2) ? dp[i - dp[i-1] - 2] : 0) + 2;
     * }
     *
     * 总之确实是自己思路不太过关，但是为了增长见识，那就从多学多背开始吧。
     */

    /**
     * Official DP solution. (But TLE for the last case 2333333)
     */
//    public int longestValidParentheses(String s) {
//        int maxLen = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i-1) == '(') {
//                    dp[i] = (i >= 2) ? dp[i-2] + 2 : 2;
//                } else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
//                    dp[i] = dp[i-1] + ((i - dp[i-1] >=2) ? dp[i - dp[i-1] - 2] : 0) + 2;
//                }
//            }
//            maxLen = Math.max(maxLen, dp[i]);
//        }
//        return maxLen;
//    }

    /**
     * An accepted solution using stack.
     */
//    public int longestValidParentheses(String s) {
//        int res = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(')
//                stack.push(i);
//            else {
//                stack.pop();
//                if (stack.isEmpty()) stack.push(i);
//                res = Math.max(res, i - stack.peek());
//            }
//        }
//        return res;
//    }
}
