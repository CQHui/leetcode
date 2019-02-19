package com.qihui.medium.array;

import java.util.HashSet;

/**
 * @author chenqihui
 * @date 2019/2/19
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        //存放要清理行列序号 最大容量为 行 + 列
        HashSet<Integer> set = new HashSet<>(matrix.length + matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set.add(i);
                    //区分出列，从matrix.length开始计数
                    set.add(matrix.length + j);
                }
            }
        }
        for (Integer index : set) {
            if (index < matrix.length) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[index][j] = 0;
                }
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][index - matrix.length] = 0;
                }
            }
        }
    }
}
