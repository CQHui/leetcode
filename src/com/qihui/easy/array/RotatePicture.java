package com.qihui.easy.array;

/**
 * @author chenqihui
 * @date 2018/11/11
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotatePicture {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - i - 1; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp1 = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = matrix[i][j];
                int temp2 = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = temp1;
                temp1 = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = temp2;
                matrix[i][j] = temp1;
            }
        }

    }
}
