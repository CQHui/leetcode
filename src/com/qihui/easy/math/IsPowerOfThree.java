package com.qihui.easy.math;

/**
 * @author chenqihui
 * @date 2018/12/16
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        double v = Math.log10(n) / Math.log10(3);
        return v - (int)v == 0;
    }
}
