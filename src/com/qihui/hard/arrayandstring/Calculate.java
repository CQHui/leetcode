package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value. 
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * @author chenqihui
 * @date 2/19/22
 */
public class Calculate {
    public int calculate(String s) {
        s = s.trim();
        Deque<Integer> deque = new LinkedList<>();
        int num = 0;
        char preChar = '+';
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                switch (preChar) {
                    case '+':
                        deque.addLast(num);
                        break;
                    case '-':
                        deque.addLast(-1 * num);
                        break;
                    case '*':
                        int v1 = deque.removeLast();
                        deque.addLast(v1 * num);
                        break;
                    case '/':
                        int v2 = deque.removeLast();
                        deque.addLast(v2 / num);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + preChar);
                }
                num = 0;
                preChar = c;
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.poll();
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(calculate("3+2*2*6"));
    }
}
