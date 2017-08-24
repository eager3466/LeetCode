package hard;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class InterleavingString {

//    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//            For example,
//    Given:
//    s1 = "aabcc",
//    s2 = "dbbca",
//
//    When s3 = "aadbbcbcac", return true.
//    When s3 = "aadbbbaccc", return false.

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length())
            return false;
        matrix[0][0] = true;
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        (matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    /**
     * 还是经典的DP，还是熟悉的味道
     *
     * 关键在于初始值和边界值的设定(matrix[0][0]、matrix[i][0]、matrix[0][j])
     * 虽然最后的那个赋值有一点点绕，但是别太钻进去想，还是可以把它写出来的
     */
}
