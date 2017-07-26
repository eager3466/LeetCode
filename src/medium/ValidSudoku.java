package medium;

import java.util.HashSet;

/**
 * Created by eager-mbp on 2017/7/22.
 */
public class ValidSudoku {

//    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//    A partially filled sudoku which is valid.
//
//            Note:
//    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells
//    need to be validated.

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    /**
     * 没什么好说的，就是检查一个零零散散的数独格子是否满足数独的特性，用set来判断元素是否重复就行了
     *
     * 值得一提的是，hashSet.add是有返回值的，true表示插入成功，也就是说没有重复元素，这点需要牢记
     *
     * 标答用/和%来遍历每个小的九宫格，这个trick一定要记住。
     *
     * Use % for horizontal traversal.
     * Use / for vertical traversal.
     *
     */
}
