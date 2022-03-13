package com.qihui.hard.treeandgraph;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *  
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *  
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 *
 * @author chenqihui
 * @date 3/13/22
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String cur;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        int step = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                cur = q.poll();
                if (similar(endWord, cur)) {
                    return step + 1;
                }
                for (String x : wordList) {
                    if (!visited.contains(x) && similar(x, cur)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean similar(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int diffNum = 0;
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                diffNum ++;
            }
            if (diffNum > 1) {
                return false;
            }
        }
        return diffNum == 1;
    }
}
