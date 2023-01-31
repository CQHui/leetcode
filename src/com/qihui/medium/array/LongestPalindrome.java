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

    public String longestPalindromeV2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[chars.length][chars.length];

        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }

        int left = 0;
        int right = 0;
        int longest = 1;

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    continue;
                }
                dp[i][j] = true;
                if (j - i > 1) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    if (j - i + 1 > longest) {
                        left = i;
                        right = j;
                        longest = j - i + 1;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
