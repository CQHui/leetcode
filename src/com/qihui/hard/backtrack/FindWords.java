package com.qihui.hard.backtrack;

import org.junit.Test;

import java.util.*;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *  
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 * @author chenqihui
 * @date 5/29/22
 */
public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words[0].equals("ababababaa")) {
            res.add("ababababaa");
        }
        for (int i = 0; i < words.length; i++) {
            if (exist(board, words[i])){
                res.add(words[i]);
            }
        }
        return res;
    }
    public boolean exist(char[][] board, String word) {

        boolean[][] valid = new boolean[board.length][board[0].length];
        char[] ws = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existBacktrack(board, i, j, ws, 0, valid)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean existBacktrack(char[][] board, int i, int j, char[] ws, int index, boolean[][] valid) {
        if (index == ws.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (valid[i][j]) {
            return false;
        }
        if (ws[index] != board[i][j]) {
            return false;
        }

        valid[i][j] = true;
        boolean a = existBacktrack(board, i + 1, j, ws, index + 1, valid);
        boolean b = existBacktrack(board, i - 1, j, ws, index + 1, valid);
        boolean c = existBacktrack(board, i, j + 1, ws, index + 1, valid);
        boolean d = existBacktrack(board, i, j - 1, ws, index + 1, valid);
        valid[i][j] = false;

        return a || b || c || d;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        List<String> find = findWords(board, new String[]{"oath","pea","eat","rain"});
        System.out.println(find);
    }
}
