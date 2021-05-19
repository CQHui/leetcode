package com.qihui.medium.backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenqihui
 * @date 5/19/21
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 */
public class GenerateParenthesis {
    int leftNum = 0;
    int rightNum = 0;
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        char[] track = new char[n * 2];
        backtrack(n, track, result);
        return result;
    }

    void backtrack(int num, char[] track, LinkedList<String> result) {
        if (leftNum == num && rightNum == num) {
            result.add(new String(track));
            return;
        }
        if (leftNum < num) {
            track[leftNum + rightNum] = '(';
            leftNum ++;
            backtrack(num, track, result);
            leftNum --;
        }
        if (rightNum < leftNum) {
            track[leftNum + rightNum] = ')';
            rightNum ++;
            backtrack(num, track, result);
            rightNum --;
        }

    }

    @Test
    public void test() {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);
    }
}
