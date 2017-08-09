package medium;

/**
 * Created by Eager-RESCUER on 2017/8/2.
 */
public class MinimumPathSum {

//    Given a m x n grid filled with non-negative numbers, find a path from top left to
//    bottom right which minimizes the sum of all numbers along its path.
//
//    Note: You can only move either down or right at any point in time.

    public int minPathSum(int[][] grid) {

        if (grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0)
            return 0;
        int sums[][] = new int[m][n];
        // Initialize position
        sums[m-1][n-1] = grid[m-1][n-1];
        for (int i = m-2; i >= 0; i--) {
            sums[i][n-1] = sums[i+1][n-1] + grid[i][n-1];
        }
        for (int i = n-2; i >= 0; i--) {
            sums[m-1][i] = sums[m-1][i+1] + grid[m-1][i];
        }
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >= 0; j--) {
                sums[i][j] = Math.min(sums[i+1][j], sums[i][j+1]) + grid[i][j];
            }
        }
        return sums[0][0];
    }

    /**
     * 依旧是DP练手，赋初值，状态转移，得到结果，一次AC，否则会感到很水
     *
     * 和标答思路van全一致
     */
}
