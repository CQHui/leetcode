package com.qihui.medium.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenqihui
 * @date 5/16/21
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *  
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *  
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 */
public class LetterCombinations {
    private final List<String> letters = Stream.of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz").collect(Collectors.toList());

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        return combineLetter(digits, result);
    }

    private List<String> combineLetter(String digits, LinkedList<String> result) {
        if (digits.length() == 0) {
            return result;
        }

        char aChar = digits.charAt(0);
        int value = aChar - 48;
        String str = letters.get(value);
        if (result.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                result.add(str.substring(i, i + 1));
            }
        } else {
            int length = result.size();
            while (length > 0) {
                String s = result.pop();
                for (int i = 0; i < str.length(); i++) {
                    result.add(s + str.substring(i, i + 1));
                }
                length --;
            }

        }
        return combineLetter(digits.substring(1), result);
    }

    @Test
    public void test() {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("234");
        System.out.println(strings);
    }
}
