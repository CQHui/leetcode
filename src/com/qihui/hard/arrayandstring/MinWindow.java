package com.qihui.hard.arrayandstring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *  
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *  
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 *
 * @author chenqihui
 * @date 2/21/22
 */
public class MinWindow {

    public  String minWindow(String s, String t) {

        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        if(tc.length > sc.length){
            return "";
        }

        //use an array to document the number of each letter
        int[] tar = new int[64];
        int[] cur = new int[64];

        int curTotal = 0;
        int curLen = sc.length + 1;
        int curL = -1;
        int l = 0;
        int r = 0;

        int total = tc.length;
        // 统计每个单词个数
        for (int i = 0; i < tc.length; i++) {
            tar[tc[i] - 'A']++;
        }

        // 判断s是否有这个单词，没有就跳过
        while(r < sc.length){
            if(tar[sc[r] - 'A'] == 0){
                r++;
                continue;
            }
            // 记录s中出现t中单词的个数和种类
            cur[sc[r] - 'A']++;
            // 个数小于或者等于该种类的都有效，并统计总数。
            if(cur[sc[r] - 'A'] <= tar[sc[r] - 'A']){
                curTotal++;
            }

            // 总数不够，就继续
            if(curTotal < total){
                r++;
                continue;
            }

            // 总数够了，去除多余单词，从最左边缩小窗口
            while(l < r){
                if(cur[sc[l] - 'A'] == 0){
                    l++;
                    continue;
                }
                // 准备让该单词个数-1，看是否还满足，满足说明不是最小的窗口，可以去除。
                cur[sc[l] - 'A']--;
                // 不满足，准备保存最小窗口
                if(cur[sc[l] - 'A'] < tar[sc[l] - 'A']) {
                    curTotal--;    // 为继续遍历做准备，剔除该索引的单词
                    break;      // 退出循环，保存最小窗口
                }
                l++;
            }
            if(r - l + 1 < curLen){
                curLen = r - l + 1;    // 保存长度
                curL = l;      // 保存初始位置
            }
            l++;    // 继续遍历
            r++;    // 继续遍历
        }
        if(curL == -1){
            return "";
        }
        // 保存结果
        char[] res = new char[curLen];
        System.arraycopy(sc, curL, res, 0, curLen);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curLen; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
