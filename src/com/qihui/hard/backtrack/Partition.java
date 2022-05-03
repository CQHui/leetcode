package com.qihui.hard.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 * @author chenqihui
 * @date 5/3/22
 */
public class Partition {
    public List<List<String>> partition(String s) {
        char[] chs = s.toCharArray();
        List<List<String>> ans = new ArrayList<>();
        split(0, 0, chs, new ArrayList<>(), ans);
        return ans;
    }

    private void split(int left, int right, char[] chs, ArrayList<String> res, List<List<String>> ans) {
        if (chs.length == right) {
            ans.add(new ArrayList<>(res));
            return;
        }
        while (right < chs.length) {
            if (isPalindrome(chs, left, right)) {
                res.add(new String(chs, left,right - left + 1));
                split(right + 1, right + 1, chs, res, ans);
                res.remove(res.size() - 1);
            }
            ++right;
        }
    }

    public boolean isPalindrome(char[] chs, int i, int j) {
        while(i < j){
            if (chs[i] != chs[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
