package com.qihui.medium.search;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 6/5/21
 *
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *  
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *  
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 *
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column <= matrix[0].length - 1) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        boolean exist = searchMatrix(matrix, 5);
        System.out.println(exist);
    }
}
