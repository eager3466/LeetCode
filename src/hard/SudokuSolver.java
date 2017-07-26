package hard;

/**
 * Created by eager-mbp on 2017/7/21.
 */
public class SudokuSolver {

//    Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//    Empty cells are indicated by the character '.'.
//
//    You may assume that there will be only one unique solution.

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][]board, int row, int col, char c) {
        int blkRow = row/3*3;
        int blkCol = col/3*3;
        for (int i = 0; i < 9; i++) {
            // i : 0 ~ 8
            if (board[row][i] == c || board[i][col] == c
                    || board[blkRow + i/3][blkCol + i%3] == c)
                return false;
        }
        return true;
    }

    public boolean isSuccessful(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }

    /**
     * 这道题修改之后就基本和标答没什么区别了，用的是Backtracking回溯法。
     * 这里有一点，因为之前看八皇后问题，递归的函数是个void类型
     * 而本题的solve()是boolean型，而且巧妙地用返回值来界定了这整个过程：
     * true -> 找到结果 -> 同时结束了之前的递归过程
     *
     * 当有一个位置为'.' -> 没有结束 -> 返回为false
     *
     * 现在仔细想想如果想得到所有的解，那应该把判断为是否结束，和solve()的这个过程拆开
     * 就像八皇后是在i>8的时候判定为结束，而且是在一次递归处理前先判断结束的
     *
     * 先记录这样的想法，以后遇到相应code的时候再解决问题~
     */
}