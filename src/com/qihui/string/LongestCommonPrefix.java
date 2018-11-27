package com.qihui.string;

/**
 * @author chenqihui
 * @date 2018/11/27
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = commonPrefix.length() > strs[i].length() ? strs[i].length() : commonPrefix.length();
            for (; j > -1 ; j--) {

                commonPrefix = commonPrefix.substring(0, j);
                if (commonPrefix.substring(0, j).equals(strs[i].substring(0, j))) {
                    break;
                }
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
