package medium;

/**
 * Created by Eager-RESCUER on 2017/8/1.
 */
public class SpiralMatrixII {

//    Given an integer n, generate a square matrix filled with elements
//    from 1 to n2 in spiral order.
//
//            For example,
//    Given n = 3,
//
//    You should return the following matrix:
//            [
//            [ 1, 2, 3 ],
//            [ 8, 9, 4 ],
//            [ 7, 6, 5 ]
//            ]

    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[][]{};
        int count = 0;
        int[][] matrix = new int[n][n];
        int[][] dirMatrix = new int[][] {{0, 1}, {1,0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int row = 0, col = -1; // initial position
        int[] range = new int[] {n, n-1};
        while(range[dir % 2] != 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += dirMatrix[dir][0];
                col += dirMatrix[dir][1];
                count++;
                matrix[row][col] = count;
            }
            range[dir % 2] -= 1;
            dir = (dir + 1) % 4;
        }
        return matrix;
    }

    /**
     * 这个题按照之前的漂亮标答又写了一遍，发现还是有一些玄机的
     * 这个解法的两点在于range[]数组用于控制上下还是左右
     *
     * 然后用dir % 2来控制纵横方向，再用方向矩阵控制具体方向
     * 需要注意的细节有：
     * int row = 0, col = -1 这对初始值，一个为0一个为-1
     * 同理，row就少循环一次，所以边界也小：int[] range = new int[] {n, n-1};
     */
}
