package com.qihui.easy.other;

/**
 * @author chenqihui
 * @date 2018/12/19
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        //异或计算不同的位
        int i = x ^ y;
        return hammingWeight(i);
    }

    public int hammingWeight(int n) {
        int count = 0;
        // 需要右移32次
        int x = 32;
        while (x-- != 0) {
            //&运算判断该位是否为1
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}
