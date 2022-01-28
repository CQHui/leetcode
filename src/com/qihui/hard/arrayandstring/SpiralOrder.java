package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author chenqihui
 * @date 1/28/22
 */
public class SpiralOrder {
    int rowMin, colMin, rowMax, colMax;
    int[][] matrix;
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        rowMax = matrix.length - 1;
        colMax = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>(rowMax * colMax);
        order(result);
        return result;
    }

    private void order(List<Integer> result) {

        for (int i = colMin; i <= colMax; i++) {
            result.add(matrix[colMin][i]);
        }
        rowMin ++;
        if (rowMin > rowMax) {
            return;
        }

        for (int i = rowMin; i <= rowMax; i++) {
            result.add(matrix[i][colMax]);
        }
        colMax --;
        if (colMax < colMin) {
            return;
        }

        for (int i = colMax; i >= colMin ; i--) {
            result.add(matrix[rowMax][i]);
        }
        rowMax --;
        if (rowMax < rowMin) {
            return;
        }

        for (int i = rowMax; i >= rowMin ; i--) {
            result.add(matrix[i][colMin]);
        }
        colMin ++;

        if (colMin > colMax) {
            return;
        }

        order(result);
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
