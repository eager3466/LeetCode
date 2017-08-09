package medium;

/**
 * Created by Eager-RESCUER on 2017/8/4
 */
public class SetMatrixZeroes {

//    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//    click to show follow up.
//
//    Follow up:
//    Did you use extra space?
//    A straight forward solution using O(mn) space is probably a bad idea.
//    A simple improvement uses O(m + n) space, but still not the best solution.
//    Could you devise a constant space solution?

    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return ;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0Zero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                col0Zero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0Zero)
                matrix[i][0] = 0;
        }
    }

    /**
     * 这道题非常小，但也很考查对空间复杂度的把握，从O(mn),O(m+n)再到 O(1)，所需的空间复杂度递减
     *
     * 其实减少空间复杂度最简单的思维就是：看看当前所占空间里，那块可以拿来直接用
     * 如果能找到一块地方来储存数据，那么就可以省下相当多级别的空间
     *
     * 比如这个题的[i][0]和[0][j]
     *
     * 同时，标答非常细腻，包括了第一行和第一列可能的重复存在
     * 加上它第二个循环是从下往上的，可以避免一些更加复杂的判断，如此简介又功能强大，值得学习
     */

//    void setZeroes(vector<vector<int> > &matrix) {
//        int col0 = 1, rows = matrix.size(), cols = matrix[0].size();
//
//        for (int i = 0; i < rows; i++) {
//            if (matrix[i][0] == 0) col0 = 0;
//            for (int j = 1; j < cols; j++)
//                if (matrix[i][j] == 0)
//                    matrix[i][0] = matrix[0][j] = 0;
//        }
//
//        for (int i = rows - 1; i >= 0; i--) {
//            for (int j = cols - 1; j >= 1; j--)
//                if (matrix[i][0] == 0 || matrix[0][j] == 0)
//                    matrix[i][j] = 0;
//            if (col0 == 0) matrix[i][0] = 0;
//        }
//    }
}
