package com.qihui.medium.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqihui
 * @date 6/16/21
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 0 <= n <= 104
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        // (n/5) + (n/5^2) + (n/5^3) + ...
        double power = 1;
        int count = 0;
        while (true) {
            double pow = Math.pow(5.0, power);
            if (n >= pow) {
                count += n / pow;
                power ++;
            } else {
                return count;
            }
        }
    }

    @Test
    public void test() {
        int i = new TrailingZeroes().trailingZeroes(5);
        System.out.println(i);
    }
}
