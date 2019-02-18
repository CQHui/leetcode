package com.qihui.easy.string;

/**
 * @author chenqihui
 * @date 2018/11/3
 *
 *编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 */
public class ReverseString {

    public String reverseString(String s) {
        if (null == s) {
            return null;
        }

        char[] chars = s.toCharArray();
        int mid = s.length() / 2;
        int length = chars.length;

        char temp;
        for (int i = 0; i < mid; i++) {
            temp = chars[i];
            chars[i] = chars[length- 1 - i];
            chars[length - 1 - i] = temp;
        }

        return new String(chars);
    }
}
