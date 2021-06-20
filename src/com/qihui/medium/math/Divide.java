package com.qihui.medium.math;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 6/20/21
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 *  
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Example 3:
 *
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * Example 4:
 *
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *  
 *
 * Constraints:
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        return doDivide(dividend, divisor);
    }

    private int doDivide(int x, int y) {
        if (x == y) {
            return 1;
        }
        boolean negative = false;
        int result = 0;
        if (y == 1) {
            return x;
        }
        if (y == -1) {
            return x == Integer.MIN_VALUE ? Integer.MAX_VALUE : -x;
        }
        if (y < 0) {
            y = -y;
            negative = true;
        }
        if (x < 0) {
            while (x <= 0) {
                result ++;
                x = x + y;
            }
            negative = !negative;
        } else if (x == 0) {
            return 0;
        } else {
            while (x >= 0) {
                result ++;
                x = x - y;
            }
        }
        if (result < 0) {
            return Integer.MAX_VALUE;
        }
        if (negative) {
            return -result + 1;
        }
        return result - 1;
    }

    @Test
    public void test() {
        int divide = divide(-2147483648, -1);
        System.out.println(divide);
    }
}
