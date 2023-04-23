package com.qihui.medium.linklist;

import org.junit.Test;

import java.util.*;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *  
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *  
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * Created by Elliott Chen on 2023/4/23 14:19
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        int[][] dps = new int[charArray1.length][charArray2.length];
        if (charArray1[0] == charArray2[0]) {
            dps[0][0] = 1;
        } else {
            dps[0][0] = 0;
        }
        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (i == 0 & j == 0) {
                    continue;
                }
                if (i == 0) {
                    if (charArray1[0] == charArray2[j]) {
                        dps[0][j] = 1;
                    } else {
                        dps[0][j] = dps[0][j - 1];
                    }
                    continue;
                }

                if (j == 0) {
                    if (charArray1[i] == charArray2[0]) {
                        dps[i][0] = 1;
                    } else {
                        dps[i][0] = dps[i - 1][0];
                    }
                    continue;
                }
                if (charArray2[j] == charArray1[i]) {
                    dps[i][j] = dps[i - 1][j - 1] + 1;
                } else {
                    dps[i][j] = Math.max(dps[i][j - 1], dps[i - 1][j]);
                }
            }
        }
        return dps[charArray1.length - 1][charArray2.length - 1];
    }


    @Test
    public void test() {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

}


