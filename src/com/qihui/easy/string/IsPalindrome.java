package com.qihui.easy.string;

/**
 * @author chenqihui
 * @date 2018/11/15
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public  boolean isPalindromeisPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        if ("".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] > 47 && chars[i] < 58 && chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
            if (chars[i] != chars[chars.length - 1 - i]
                    && chars[i] - chars[chars.length - 1 - i] != 32
                    && chars[chars.length - 1 - i] - chars[i] != 32) {
                return false;
            }
        }
        return true;
    }
}
