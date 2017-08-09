package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class NQueensII {

//    Follow up for N-Queens problem.
//
//    Now, instead outputting board configurations, return the total number of distinct solutions.

    int total = 0;

    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = initBoard(n);
        backtracking(res, board, 0);
        return total;
    }

    private void backtracking(List<List<String>> res, char[][] board, int i) {
        if (i == board[0].length) {
            total++;
            return;
        }
        for (int j = 0; j < board[0].length; j++) {
            if (isValid(board, i, j)) {
                board[i][j] = 'Q';
                backtracking(res, board, i + 1);
                board[i][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q')
                return false;
            if (j-(i-k) >= 0 && board[k][j-(i-k)] == 'Q')
                return false;
            if (j+(i-k) <= board[0].length-1 && board[k][j+(i-k)] == 'Q')
                return false;
        }
        return true;
    }

    public char[][] initBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    /**
     * 同八皇后1题。
     *
     * 看了下Discuss里的另外一种解法，意在不用专门画棋盘，而是用三个boolean数组来记录
     * 水平、左向对角线、右向对角线分别是否available
     *
     * 其中，对角线数组的申请长度为2*n-1
     * 45° 对角线用 col + row     来表示
     * 135°对角线用 n-1-(row-col) 来表示
     *
     * 仔细算一下就得出这些其实很好地模拟了二维棋盘数组里的各个位置
     * 只是其他地方不用多余的'.'来填充代替而已
     */

//    public class Solution {
//        int result = 0;
//        public int totalNQueens(int n) {
//            boolean[] column = new boolean[n];
//            boolean[] dia45 = new boolean[2 * n - 1];
//            boolean[] dia135 = new boolean[2 * n - 1];
//            helper(0, n, column, dia45, dia135);
//            return result;
//        }
//        private void helper(int row, int n, boolean[] column, boolean[] dia45, boolean[] dia135) {
//            if (row == n) {
//                result++;
//                return;
//            }
//            for (int col = 0; col < n; col++) {
//                if (!column[col] && !dia45[col + row] && !dia135[n - 1- row + col]) {
//                    column[col] = dia45[col + row] = dia135[n - 1- row + col] = true;
//                    helper(row + 1, n, column, dia45, dia135);
//                    column[col] = dia45[col + row] = dia135[n - 1- row + col] = false;
//                }
//            }
//        }
//    }
}
