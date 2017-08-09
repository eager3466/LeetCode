package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class SpiralMatrix {

//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix
//    in spiral order.
//
//    For example,
//    Given the following matrix:
//
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    You should return [1,2,3,6,9,8,7,4,5].

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }

    /**
     * 本题没有太大的算法意义，想实现总是可以实现
     * 只是看谁的设计更好，方法更简单，代码更优雅
     *
     * 一种是最简单直观的方法，先右，然后下，再左，最后上
     * 下一圈时，这个循环的边界尺寸会小一些
     *
     * 另一种标答更好，模拟了四种方向，而且处理逆时针的该问题时也可以直接用得上，这里很棒
     * dirMatrix和dir相配合，使得整个代码简洁、优雅，可扩展（至少在2-D上）
     */

//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<Integer>();
//        //
//        int m = matrix.length;
//        if(m == 0) return res;
//        int n = matrix[0].length;
//        if(n == 0) return res;
//        //
//        int[][] dirMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int[] range = {n, m-1};
//        int dir = 0;           // index of dirMatrix, 0: right, 1: down, 2: left, 3: up
//        int row = 0, col = -1; // initial position
//
//        while(range[dir%2] != 0){
//            for(int i = 0; i < range[dir%2]; i += 1){
//                row += dirMatrix[dir][0];
//                col += dirMatrix[dir][1];
//                res.add(matrix[row][col]);
//            }
//
//            range[dir%2] -= 1;
//            dir = (dir + 1) % 4;
//        }
//
//        return res;
//
//    }
}
