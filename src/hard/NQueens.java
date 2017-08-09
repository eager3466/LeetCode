package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class NQueens {

//    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
//    no two queens attack each other.
//
//    Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//    Each solution contains a distinct board configuration of the n-queens' placement,
//    where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//    For example,
//    There exist two distinct solutions to the 4-queens puzzle:
//
//            [
//            [".Q..",  // Solution 1
//            "...Q",
//            "Q...",
//            "..Q."],
//
//            ["..Q.",  // Solution 2
//            "Q...",
//            "...Q",
//            ".Q.."]
//            ]
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = initBoard(n);
        backtracking(res, board, 0);
        return res;
    }

    private void backtracking(List<List<String>> res, char[][] board, int i) {
        if (i == board[0].length) {
            saveBoard(res, board);
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

    private void saveBoard(List<List<String>> res, char[][] board) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        res.add(list);
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
     * 没啥说的，这么久了，一遍总得撸出个AC代码来吧。
     */
}
