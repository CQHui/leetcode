package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenqihui
 * @date 2/8/22
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] cloneBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            cloneBoard[i] = board[i].clone();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    int count = count(cloneBoard, i, j);
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    int count = count(cloneBoard, i, j);
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    private int count(int[][] board, int row, int column) {
        int count = 0;
        if (row > 0) {
            if (column > 0) {
                if (board[row - 1][column - 1] == 1) {
                    count ++;
                }
            }
            if (board[row - 1][column] == 1) {
                count ++;
            }
            if (column < board[0].length - 1) {
                if (board[row - 1][column + 1] == 1) {
                    count ++;
                }
            }
        }
        if (column > 0) {
            if (board[row][column - 1] == 1) {
                count ++;
            }
        }
        if (column < board[0].length - 1) {
            if (board[row][column + 1] == 1) {
                count ++;
            }
        }
        if (row < board.length - 1) {
            if (column > 0) {
                if (board[row + 1][column - 1] == 1) {
                    count ++;
                }
            }
            if (board[row + 1][column] == 1) {
                count ++;
            }
            if (column < board[0].length - 1) {
                if (board[row + 1][column + 1] == 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
