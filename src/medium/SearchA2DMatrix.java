package medium;

/**
 * Created by Eager-RESCUER on 2017/8/4
 */
public class SearchA2DMatrix {

//    Write an efficient algorithm that searches for a value in an m x n matrix.
//    This matrix has the following properties:
//
//    Integers in each row are sorted from left to right.
//    The first integer of each row is greater than the last integer of the previous row.
//    For example,
//
//    Consider the following matrix:
//
//            [
//            [1,   3,  5,  7],
//            [10, 11, 16, 20],
//            [23, 30, 34, 50]
//            ]
//    Given target = 3, return true.

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue > target) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 正如标答所说，在这样一个元素排序了的矩阵里进行查找，和普通的二分查找一模一样
     *
     * 唯一需要注意的是int[][]和int[]之间坐标转换所需要做准确的细节
     * 比如 int midValue = matrix[mid / n][mid % n] ，两个都是对n处理，和m没有关系
     */
}
