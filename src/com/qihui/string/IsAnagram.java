package com.qihui.string;

/**
 * @author chenqihui
 * @date 2018/11/13
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '-') {
                continue;
            }
            int j;
            for (j = 0; j < tChars.length; j++) {
                if (sChars[i] == '-') {
                    continue;
                }
                if (sChars[i] == tChars[j]) {
                    sChars[i] = '-';
                    tChars[j] = '-';
                    break;
                }
            }
            if (j == tChars.length) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramAnswer(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        if(array1.length!=array2.length){
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<s.length();i++)a[array1[i]-'a']++;
        for(int i=0;i<t.length();i++)b[array2[i]-'a']++;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
