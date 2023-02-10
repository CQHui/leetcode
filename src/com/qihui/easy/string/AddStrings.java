package com.qihui.easy.string;

import org.junit.Test;


/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *  
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *  
 * Constraints:
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] char1, char2;
        if (num1.length() > num2.length()) {
            char1 = num1.toCharArray();
            char2 = num2.toCharArray();
        } else {
            char1 = num2.toCharArray();
            char2 = num1.toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        boolean plusOne = false;
        for (int i = 0; i < char1.length; i++) {
            int sum;
            if (char2.length - 1 - i >= 0) {
                sum = char1[char1.length - 1 - i] - '0' + (char2[char2.length - 1 - i] - '0');
            } else {
                sum = char1[char1.length - 1 - i] - '0';
            }
            sum = plusOne ? sum + 1 : sum;
            if (sum > 9) {
                sum = sum - 10;
                sb.append(sum);
                plusOne = true;
            } else {
                sb.append(sum);
                plusOne = false;
            }
        }
        if (plusOne) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addStrings("11", "123"));
    }
}
