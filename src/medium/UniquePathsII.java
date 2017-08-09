package medium;

/**
 * Created by Eager-RESCUER on 2017/8/2.
 */
public class UniquePathsII {

//    Follow up for "Unique Paths":
//
//    Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//    For example,
//    There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//        [
//        [0,0,0],
//        [0,1,0],
//        [0,0,0]
//        ]
//    The total number of unique paths is 2.
//
//    Note: m and n will be at most 100.

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0)
            return 0;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int step[][] = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            if (obstacleGrid[i][n-1] == 0) {
                step[i][n - 1] = 1;
            } else {
                break;
            }
        }
        for (int i = n-1; i >=0; i--) {
            if (obstacleGrid[m-1][i] == 0) {
                step[m-1][i] = 1;
            } else {
                break;
            }
        }
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 0) {
                    step[i][j] = step[i + 1][j] + step[i][j + 1];
                } else {
                    step[i][j] = 0;
                }
            }
        }
        return step[0][0];
    }

    /**
     * 对1题稍加改动，修复了几个case，还是能写出来的
     *
     * 不过有大佬可以用一维数组写出来dp解法，深感佩服，回头再研究这个算法
     *
     * Update in 2017/8/3:
     * 仔细看了下这个算法，当然了其实都一样，只是下一次相加的时候能用更简单的方式来表达
     * 实质当然是current cell = top cell + left cell
     *
     dp[j] += dp[j - 1];
     is
     dp[j] = dp[j] + dp[j - 1];
     which is new dp[j] = old dp[j] + dp[j-1]
     which is current cell = top cell + left cell

     Hope this helps.
     */

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int width = obstacleGrid[0].length;
//        int[] dp = new int[width];
//        dp[0] = 1;
//        for (int[] row : obstacleGrid) {
//            for (int j = 0; j < width; j++) {
//                if (row[j] == 1)
//                    dp[j] = 0;
//                else if (j > 0)
//                    dp[j] += dp[j - 1];
//            }
//        }
//        return dp[width - 1];
//    }
}
