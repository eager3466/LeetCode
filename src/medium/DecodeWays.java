package medium;

/**
 * Created by eager-mbp on 2017/8/16.
 */
public class DecodeWays {

//    A message containing letters from A-Z is being encoded to numbers using the
//    following mapping:
//
//            'A' -> 1
//            'B' -> 2
//            ...
//            'Z' -> 26
//    Given an encoded message containing digits, determine the total number of ways to decode it.
//
//    For example,
//    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//    The number of ways decoding "12" is 2.

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if (first >= 1 && first <= 9)
                dp[i] = dp[i-1];
            if (second >= 10 && second <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }

    /**
     * 这个算法非常需要去思考，尤其是
     * if (first >= 1 && first <= 9)
        dp[i] = dp[i-1];
        这个需要想很久

        其实对于添加的最后一个数字和之前倒数第一个数字之间有没有联动，构成新的DecodeWay
        这是i == len的时候来处理的

        这道题的关键是多用一个位置来储存dp结果
        并且有 i == len时的处理

        仔细一想dp[i] = dp[i-1]主要处理的是末尾为0的情况，将其划分清楚

        非常值得回味的一道题
     */
}
