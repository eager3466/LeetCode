package hard;

/**
 * Created by Eager-RESCUER on 2017/8/4
 */
public class EditDistance {

//    Given two words word1 and word2, find the minimum number of steps required to
//    convert word1 to word2. (each operation is counted as 1 step.)
//
//    You have the following 3 operations permitted on a word:
//
//    a) Insert a character
//    b) Delete a character
//    c) Replace a character

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]);
                    dp[i+1][j+1] = Math.min(dp[i][j], dp[i+1][j+1]);
                    dp[i+1][j+1] = dp[i+1][j+1] + 1;
                }
            }
        }
        return dp[m][n];
    }


//    public int minDistance(String word1, String word2) {
//        if (word1 == null && word2 == null)
//            return 0;
//
//        return recursive(word1, 0, word2, 0);
//    }
//
//    private int recursive(String word1, int i1, String word2, int i2) {
//        if (i1 >= word1.length())
//            return (i2 >= word2.length()) ? 0 : word2.length() - i2;
//        if (i2 >= word2.length())
//            return (i1 >= word1.length()) ? 0 : word1.length() - i1;
//        int carry;
//        int min = Integer.MAX_VALUE;
//        if (word1.charAt(i1) == word2.charAt(i2)) {
//            return recursive(word1, i1+1, word2, i2+1);
//        } else {
//            carry = 1;
//            min = Math.min(recursive(word1, i1+1, word2, i2+1), min);
//            min = Math.min(recursive(word1, i1+1, word2, i2), min);
//            min = Math.min(recursive(word1, i1, word2, i2+1), min);
//        }
//        return min + carry;
//    }

    /**
     * 作为非常经典的当年很摸不到头脑的“编辑距离”一题，这次终于结合标答把自己的解法写出来了！
     *
     * 一开始想的是递归，状态转移上自己其实写对了，就是f(i,j) = min(f(i-1, j-1), f(i, j-1), f(i-1, j))
     * 但是递归确实时间复杂度高到姥姥家去了，还是应该用DP的二维数组来解决
     *
     * 这两种思路差就差在存储的数据格式，一个是用返回值来得到结果，另一个是用二维数组，明显是后者好得多。
     *
     * 替换，删除这两种操作非常好理解，但是添加一个元素不太好理解
     * 几经思考之后，觉得添加 = f(i-1, j-1) 操作之后再加上一个元素  f(i-1, j)
     * 所以实质上和删除一个元素是差不多的，只是添加是针对短的字符串，而删除是针对较长字符串的
     */
}
