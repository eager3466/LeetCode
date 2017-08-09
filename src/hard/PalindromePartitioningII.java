package hard;

/**
 * Created by Eager-RESCUER on 2017/8/8
 */
public class PalindromePartitioningII {

//    Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return the minimum cuts needed for a palindrome partitioning of s.
//
//    For example, given s = "aab",
//    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

    public int minCut(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        boolean [][] isPalin = new boolean[n][n];
        int[] dp = new int[n];
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && ((i - j < 2) || isPalin[i-1][j+1])) {
                    isPalin[j][i] = true;
//                    if (j == 0) {
//                        min = 0;
//                        break;
//                    } else {
//                        min = Math.min(min, dp[j-1] + 1);
//                    }
                    //以上写法是错误的，应该用下面的写法
                    min = j == 0 ? 0 : Math.min(min, dp[j-1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

//    public int minCut(String s) {
//        char[] c = s.toCharArray();
//        int n = c.length;
//        int[] cut = new int[n];
//        boolean[][] pal = new boolean[n][n];
//
//        for(int i = 0; i < n; i++) {
//            int min = i;
//            for(int j = 0; j <= i; j++) {
//                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
//                    pal[j][i] = true;
//                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
//                }
//            }
//            cut[i] = min;
//        }
//        return cut[n - 1];
//    }

//    class Solution {
//        public:
//        int minCut(string s) {
//            int n = s.size();
//            vector<int> cut(n+1, 0);  // number of cuts for the first k characters
//            for (int i = 0; i <= n; i++) cut[i] = i-1;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; i-j >= 0 && i+j < n && s[i-j]==s[i+j] ; j++) // odd length palindrome
//                    cut[i+j+1] = min(cut[i+j+1],1+cut[i-j]);
//
//                for (int j = 1; i-j+1 >= 0 && i+j < n && s[i-j+1] == s[i+j]; j++) // even length palindrome
//                    cut[i+j+1] = min(cut[i+j+1],1+cut[i-j+1]);
//            }
//            return cut[n];
//        }
//    };
}
