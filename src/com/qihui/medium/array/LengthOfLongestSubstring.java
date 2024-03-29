package com.qihui.medium.array;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author chenqihui
 * @date 2019/2/25
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        for (int i = 1; i <= chars.length - max;) {
            for (int j = 1; j <= max; j++) {
                int rightBorder = i + j -1;
                if (rightBorder == s.length()) {
                    break;
                }
                String shortStr = s.substring(i - 1, rightBorder);
                int charInShortString = shortStr.indexOf(chars[rightBorder]);
                if (charInShortString != -1) {
                    i = charInShortString + i + 1;
                    break;
                }

                max = shortStr.length() == max ? max + 1 : max;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringWithSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            for (; j < chars.length; j++) {
                if (!set.add(chars[j])) {
                    break;
                }
            }
            ans = Math.max(ans, set.size());
            set.remove(chars[i]);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstringWithSet("pwwkew"));
    }
}
