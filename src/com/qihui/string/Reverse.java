package com.qihui.string;

/**
 * @author chenqihui
 * @date 2018/11/5
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse {

    public int reverse(int x) {
        boolean isPlus;
        if (x > 0) {
            isPlus = true;
        } else {
            isPlus = false;
            x = 0 - x;
        }
        int remainder;
        long sum = 0;

        while(x > 0) {
            remainder = x % 10;
            x = x / 10;
            sum = sum * 10 + remainder;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
        }

        if (isPlus) {
            return (int) sum;
        } else {
            return (int) (0 - sum);
        }
    }
}
