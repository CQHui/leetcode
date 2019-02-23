package com.qihui.medium.array;

import org.junit.Test;

import java.util.*;

/**
 * @author chenqihui
 * @date 2019/2/23
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ch = String.valueOf(chars);
            if (!map.containsKey(ch)) {
                List<String> value = new LinkedList<>();
                map.put(ch, value);
                value.add(str);
            } else {
                map.get(ch).add(str);
            }
        }
        for (String str : map.keySet()) {
            result.add(map.get(str));
        }
        return result;
    }

    @Test
    public void test() {
        String[] strs= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

}
