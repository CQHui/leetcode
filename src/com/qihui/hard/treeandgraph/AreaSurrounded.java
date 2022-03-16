package com.qihui.hard.treeandgraph;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 3/15/22
 */
public class AreaSurrounded {
    int row, column;
    public void solve(char[][] board) {
        if (board[0].length == 0) {
            return;
        }

        row = board.length;
        column = board[0].length;

        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, column - 1);
        }
        for (int i = 1; i < column - 1; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= column || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    @Test
    public void test() {
        char[][] board = new char[][]{{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};

        solve(board);
    }
}
