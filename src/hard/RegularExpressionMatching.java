package hard;

/**
 * Created by eager-mbp on 2017/7/3.
 */
public class RegularExpressionMatching {


    /**
     * Description

     Implement regular expression matching with support for '.' and '*'.

            '.' Matches any single character.
            '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
    */

    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return false;
        // for s="" and p=""
        if (s.equals(p)) return true;
        int i=0, j=0;
        while (i<s.length() && j<p.length()) {
            if (s.charAt(i) != p.charAt(j) && p.charAt(j)!='.') {
                return false;
            } else {

            }
        }
        return false;
    }

    /**
     * 说实话这样的字符串匹配问题我自己是想不出来的，我想的是从左到右慢慢一位一位读。
     * 看了些类似题目描述，都是通过DP来做的。找到状态，往终点推，这是DP用来解决字符串问题的基本方法。
     * 方向是非常重要的，坐标从大到小递推还是从小到大，这非常非常重要，本题需要推断整体是否match，
     * 状态值为state[i][j],最终要求的是state[m][n],所以要从小往大推。
     * 储存结果的时候，需要2D matrix，来保存各个状态。
     *
     * 答案里对于状态把控说明的很清楚，遇到各种情况指针要怎么走，非常值得学习。
     *
     * 这里的边界条件赋值是非常烧脑的，就是state[0][j]的赋值，意思是s=""的情况下，p是什么才能match
     * 在state[0][0]=true的情况下处理p="*a*b*c"然而依旧match的case
     */

//    public boolean isMatch(String s, String p) {
//        if(s == null || p == null) {
//            return false;
//        }
//        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
//        state[0][0] = true;
//        // no need to initialize state[i][0] as false
//        // initialize state[0][j]
//        for (int j = 1; j < state[0].length; j++) {
//            if (p.charAt(j - 1) == '*') {
//                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
//                    state[0][j] = true;
//                }
//            }
//        }
//        for (int i = 1; i < state.length; i++) {
//            for (int j = 1; j < state[0].length; j++) {
//                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
//                    state[i][j] = state[i - 1][j - 1];
//                }
//                if (p.charAt(j - 1) == '*') {
//                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
//                        state[i][j] = state[i][j - 2];
//                    } else {
//                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
//                    }
//                }
//            }
//        }
//        return state[s.length()][p.length()];
//    }

    public boolean isMatchRetry(String s, String p) {
        if (s==null || p==null) return false;
        boolean state[][] = new boolean[s.length()+1][p.length()+1];
        state[0][0] = true;
        // initialize state[0][j]

        /**
         * 和标准答案的初始化有所区别，但也是用了题目的隐含条件，比如'*'一定会在某个字符后出现
         * 切记切记第state[0][j]是p串的第j个字符
         * 对应字符是p.chatAt(j-1)
         *
         * 意思就是说，你这个位置j的字符，值是*（下标是j-1)，那你的状态值，就和j-2的那个字符相同
         */
        for (int j=2; j<state[0].length; j++) {
            if (p.charAt(j-1) == '*') {
                if (state[0][j-2]) {
                    state[0][j] = true;
                }
            }
        }
        //"aab", "c*a*b"

        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    state[i+1][j+1] = state[i][j];
                }
                if (p.charAt(j) == '.') {
                    state[i+1][j+1] = state[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (j>0 && p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        state[i+1][j+1] = state[i+1][j+1-2];
                    } else {
                        state[i+1][j+1] = state[i][j+1] ||
                                state[i+1][j] || state[i+1][j+1-2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
}
