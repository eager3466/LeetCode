package medium;

/**
 * Created by Eager-RESCUER on 2017/8/2.
 */
public class UniquePaths {

//    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//    The robot can only move either down or right at any point in time. The robot is trying to reach
//    the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//    How many possible unique paths are there?
//
//
//    Above is a 3 x 7 grid. How many possible unique paths are there?
//
//    Note: m and n will be at most 100.

    public int uniquePaths(int m, int n) {
        int step[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            step[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            step[m-1][i] = 1;
        }
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >= 0; j--) {
                step[i][j] = step[i+1][j] + step[i][j+1];
            }
        }
        return step[0][0];
    }

    /**
     * 找到了状态转移的式子之后，DP递推求解即可。
     *
     * 也有人用组合的方式进行了数学求解，可以一看
     */

//    This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to
//    move exactly m-1 steps down and n-1 steps right and these can be done in any order.
//
//    For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down
//    and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and
//    right as 'R', following is one of the path :-)
//
//    D R R R D R R R
//
//    We have to tell the total number of permutations of the above given word. So, decrease both
//    m & n by 1 and apply following formula:-
//
//    Total permutations = (m+n)! / (m! * n!)
//
//    Following is my code doing the same :-)

//    public class Solution {
//        public int uniquePaths(int m, int n) {
//            if(m == 1 || n == 1)
//                return 1;
//            m--;
//            n--;
//            if(m < n) {              // Swap, so that m is the bigger number
//                m = m + n;
//                n = m - n;
//                m = m - n;
//            }
//            long res = 1;
//            int j = 1;
//            for(int i = m+1; i <= m+n; i++, j++){
//                // Instead of taking factorial, keep on multiply & divide
//                res *= i;
//                res /= j;
//            }
//
//            return (int)res;
//        }
//    }
}
