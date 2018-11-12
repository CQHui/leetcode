package com.qihui.string;

/**
 * @author chenqihui
 * @date 2018/11/12
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                continue;
            }
            if (i == chars.length - 1) {
                return i;
            }
            boolean flag = false;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    chars[j] = '-';
                    flag = true;
                    continue;
                }
                if (j == chars.length -1 && !flag) {
                    return i;
                }

            }
        }
        return -1;
    }
}
