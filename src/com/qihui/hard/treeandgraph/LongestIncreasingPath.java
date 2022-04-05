package com.qihui.hard.treeandgraph;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 *
 * @author chenqihui
 * @date 4/5/22
 */
public class LongestIncreasingPath {
    // 0: ready, -1:processing, other:length
    int[][] lengths;
    int ans = 1;
    public int longestIncreasingPath(int[][] matrix) {

        lengths = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                findLength(matrix, i, j);
            }
        }
        return ans;
    }

    public void findLength(int[][] matrix, int i, int j) {
        if (lengths[i][j] == -1 || lengths[i][j] > 0) {
            return;
        }
        lengths[i][j] = -1;
        int length = 1;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            findLength(matrix, i - 1, j);
            length = Math.max(length, lengths[i - 1][j] + 1);
        }
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
            findLength(matrix, i + 1, j);
            length = Math.max(length, lengths[i + 1][j] + 1);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            findLength(matrix, i, j - 1);
            length = Math.max(length, lengths[i][j - 1] + 1);
        }
        if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1])  {
            findLength(matrix, i, j + 1);
            length = Math.max(length, lengths[i][j + 1] + 1);
        }
        lengths[i][j] = length;
        ans = Math.max(ans, length);
    }
}
