package com.qihui.medium.math;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 6/19/21
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *  
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *  
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 *
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        if (x > 2147395599) {
            return 46340;
        }
        return findSqrt(0, x, x);
    }

    private int findSqrt(int left, int right, int x) {
        int mid = (left + right) / 2;
        if (mid > 46339) {
            return findSqrt(left, mid, x);
        }
        int productResult = mid * mid;
        if (productResult == x) {
            return mid;
        }
        if (productResult > x) {
            int temp = mid - 1;
            if (temp * temp < x) {
                return temp;
            }
            return findSqrt(left, mid, x);
        } else {
            int temp = mid + 1;
            if (temp * temp > x) {
                return mid;
            }
            return findSqrt(mid, right, x);
        }
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));

    }

}
