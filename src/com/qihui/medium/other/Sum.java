package com.qihui.medium.other;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *  
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *  
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 *
 * @author chenqihui
 * @date 6/22/21
 */
public class Sum {
    public int getSum(int a, int b) {
        return add(a, b);
    }

    private int add(int a,int b) {
        if (b == 0)
            return a;
        return add(a^b,(a & b) << 1);
    }
}
