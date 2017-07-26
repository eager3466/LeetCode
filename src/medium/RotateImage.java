package medium;

/**
 * Created by eager-mbp on 2017/7/25
 */
public class RotateImage {

//    You are given an n x n 2D matrix representing an image.
//
//    Rotate the image by 90 degrees (clockwise).
//
//    Follow up:
//    Could you do this in-place?

    public void rotate(int[][] matrix) {
        if (matrix == null) return ;
        int size = matrix[0].length - 1;
        int n = (matrix[0].length - 1) / 2;
        // i means layer of square, also refers to diagonal line index
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < size - i * 2; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[size-i-j][i];
                matrix[size-i-j][i] = matrix[size-i][size-i-j];
                matrix[size-i][size-i-j] = matrix[i+j][size-i];
                matrix[i+j][size-i] = temp;
            }
        }
    }
    /**
     * 凡是这样的数学题目，总是有比较直接的算法
     * 但是自己的想法最终AC了，也是非常欣慰
     *
     * 我的算法是把数字4个一组，转圈90°的那种，每次交换这四个
     * 最终坐标算的有点久，但是还是值得的，至少不是那么机械的矩阵操作了
     */

//    /*
//     * clockwise rotate
//     * first reverse up to down, then swap the symmetry
//     * 1 2 3     7 8 9     7 4 1
//     * 4 5 6  => 4 5 6  => 8 5 2
//     * 7 8 9     1 2 3     9 6 3
//    */
//    void rotate(vector<vector<int> > &matrix) {
//        reverse(matrix.begin(), matrix.end());
//        for (int i = 0; i < matrix.size(); ++i) {
//            for (int j = i + 1; j < matrix[i].size(); ++j)
//                swap(matrix[i][j], matrix[j][i]);
//        }
//    }
//
//    /*
//     * anticlockwise rotate
//     * first reverse left to right, then swap the symmetry
//     * 1 2 3     3 2 1     3 6 9
//     * 4 5 6  => 6 5 4  => 2 5 8
//     * 7 8 9     9 8 7     1 4 7
//    */
//    void anti_rotate(vector<vector<int> > &matrix) {
//        for (auto vi : matrix) reverse(vi.begin(), vi.end());
//        for (int i = 0; i < matrix.size(); ++i) {
//            for (int j = i + 1; j < matrix[i].size(); ++j)
//                swap(matrix[i][j], matrix[j][i]);
//        }
//    }
}
