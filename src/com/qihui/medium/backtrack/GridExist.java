package com.qihui.medium.backtrack;

import org.junit.Test;

import java.util.List;

/**
 * @author chenqihui
 * @date 5/25/21
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *  
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 */
public class GridExist {
    char[] word;
    public boolean exist(char[][] board, String word) {
        this.word = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean b = backTrack(board, i, j, new boolean[board.length][board[0].length], 0);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int row, int column, boolean[][] visited, int index) {
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
            return false;
        }
        char c = word[index];
        if (board[row][column] != c) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }
        visited[row][column] = true;
        index++;
        if (word.length == index) {
            return true;
        }
        if (backTrack(board, row - 1, column, visited, index)) {
            return true;
        }

        if (backTrack(board, row + 1, column, visited, index)) {
            return true;
        }

        if (backTrack(board, row, column - 1, visited, index)) {
            return true;
        }

        if (backTrack(board, row, column + 1, visited, index)) {
            return true;
        }
        visited[row][column] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
//                {'A'}
        };
        boolean exist = exist(board, "ABCESEEEFS");
        System.out.println(exist);
    }
}
