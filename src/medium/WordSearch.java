package medium;

import javax.swing.*;

/**
 * Created by Eager-RESCUER on 2017/8/7
 */
public class WordSearch {

//    Given a 2D board and a word, find if the word exists in the grid.
//
//    The word can be constructed from letters of sequentially adjacent cell,
//    where "adjacent" cells are those horizontally or vertically neighboring.
//    The same letter cell may not be used more than once.
//
//            For example,
//    Given board =
//
//[
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//    word = "ABCCED", -> returns true,
//    word = "SEE", -> returns true,
//    word = "ABCB", -> returns false.

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || word.length() == 0)
            return false;

        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, i, j, word, 0, isUsed))
                    return true;
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int i, int j, String word, int index,
                            boolean[][] isUsed) {
        boolean isExist = false;
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1)
            return false;
        if (index > word.length() - 1)
            return true;
        if (board[i][j] == word.charAt(index) && !isUsed[i][j]) {
            isUsed[i][j] = true;
            isExist =  isExist(board, i + 1, j, word, index + 1, isUsed) ||
                    isExist(board, i, j + 1, word, index + 1, isUsed) ||
                    isExist(board, i - 1, j, word, index + 1, isUsed) ||
                    isExist(board, i, j - 1, word, index + 1, isUsed);
            isUsed[i][j] = false;
        } else {
            isExist = false;
        }
        return isExist;
    }

    /**
     * 思路和标答非常相近，也靠自己的力量把这个题写出来了
     *
     * 只不过我多用了O(mn) extra space
     * 其他人的trick是把元素变成一个不存在matrix中的元素，然后再变回来
     * 有的是char^=256将字母变成非字母，有的是将其变成'*'，都是一种方法吧
     */

//    public class Solution {
//        public boolean exist(char[][] board, String word) {
//            for (int i = 0; i < board.length; i++)
//                for (int j = 0; j < board[0].length; j++) {
//                    if (exist(board, i, j, word, 0))
//                        return true;
//                }
//            return false;
//        }
//
//        private boolean exist(char[][] board, int i, int j, String word, int ind) {
//            if (ind == word.length()) return true;
//            if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
//                return false;
//            board[i][j] = '*';
//            board[y][x] ^= 256;
//            boolean result = exist(board, i - 1, j, word, ind + 1) ||
//                    exist(board, i, j - 1, word, ind + 1) ||
//                    exist(board, i, j + 1, word, ind + 1) ||
//                    exist(board, i + 1, j, word, ind + 1);
//            board[i][j] = word.charAt(ind);
//            board[y][x] ^= 256;
//            return result;
//        }
//    }
}
