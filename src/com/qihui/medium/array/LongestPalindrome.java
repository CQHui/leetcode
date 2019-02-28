package com.qihui.medium.array;

/**
 * @author chenqihui
 * @date 2019/2/27
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    /**
     * manacher算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        String newStr = init(s);

        int[] p = new int[newStr.length()];
        int pMaxIndex = 0;
        //定义对称中心，最大右边界
        int id = 0, mx = 0;
        for (int i = 1; i < newStr.length() - 1; i++) {
            if (i < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }
            while (newStr.charAt(i - p[i]) == newStr.charAt(i + p[i])) {
                p[i] ++;
            }
            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }
            if (p[i] > p[pMaxIndex]) {
                pMaxIndex = i;
            }
        }

        return newStr.substring(pMaxIndex - p[pMaxIndex] + 1, pMaxIndex + p[pMaxIndex]).replaceAll("#","");
    }

    /**
     * 插入字符统一奇回文
     * @param s
     * @return
     */
    private String init(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append("$");
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            builder.append("#");
        }
        builder.append("*");
        return builder.toString();
    }
}
