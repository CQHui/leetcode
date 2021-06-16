package com.qihui.medium.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenqihui
 * @date 6/15/21
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class HappyNumber {
    private static Map<Integer, Boolean> cache = new HashMap<>(128);
    static {
        cache.put(0, false);
        cache.put(1, true);
        cache.put(2, false);
        cache.put(3, false);
        cache.put(4, false);
        cache.put(5, false);
        cache.put(6, false);
        cache.put(7, true);
        cache.put(8, false);
        cache.put(9, false);
        cache.put(10, true);
        cache.put(11, false);
        cache.put(12, false);
        cache.put(13, true);
        cache.put(14, false);
        cache.put(15, false);
        cache.put(16, false);
        cache.put(17, false);
        cache.put(18, false);
        cache.put(19, true);
        cache.put(20, false);
        cache.put(21, false);
        cache.put(22, false);
        cache.put(23, true);
        cache.put(24, false);
        cache.put(25, false);
        cache.put(26, false);
        cache.put(27, false);
        cache.put(28, true);
        cache.put(29, false);
        cache.put(30, false);
        cache.put(31, true);
        cache.put(32, true);
        cache.put(33, false);
        cache.put(34, false);
        cache.put(35, false);
        cache.put(36, false);
        cache.put(37, false);
        cache.put(38, false);
        cache.put(39, false);
        cache.put(40, false);
        cache.put(41, false);
        cache.put(42, false);
        cache.put(43, false);
        cache.put(44, true);
        cache.put(45, false);
        cache.put(46, false);
        cache.put(47, false);
        cache.put(48, false);
        cache.put(49, true);
        cache.put(50, false);
        cache.put(51, false);
        cache.put(52, false);
        cache.put(53, false);
        cache.put(54, false);
        cache.put(55, false);
        cache.put(56, false);
        cache.put(57, false);
        cache.put(58, false);
        cache.put(59, false);
        cache.put(60, false);
        cache.put(61, false);
        cache.put(62, false);
        cache.put(63, false);
        cache.put(64, false);
        cache.put(65, false);
        cache.put(66, false);
        cache.put(67, false);
        cache.put(68, true);
        cache.put(69, false);
        cache.put(70, true);
        cache.put(71, false);
        cache.put(72, false);
        cache.put(73, false);
        cache.put(74, false);
        cache.put(75, false);
        cache.put(76, false);
        cache.put(77, false);
        cache.put(78, false);
        cache.put(79, true);
        cache.put(80, false);
        cache.put(81, false);
        cache.put(82, true);
        cache.put(83, false);
        cache.put(84, false);
        cache.put(85, false);
        cache.put(86, true);
        cache.put(87, false);
        cache.put(88, false);
        cache.put(89, false);
        cache.put(90, false);
        cache.put(91, true);
        cache.put(92, false);
        cache.put(93, false);
        cache.put(94, true);
        cache.put(95, false);
        cache.put(96, false);
        cache.put(97, true);
        cache.put(98, false);
        cache.put(99, false);
    }

    public boolean isHappy(int n) {
        Boolean resultFromCache = cache.get(n);
        if (resultFromCache!= null) {
            return resultFromCache;
        }
        int sum = 0;
        while(n / 10 != 0 || n % 10 != 0) {
            int singleDigits = n % 10;
            sum += singleDigits * singleDigits;
            n = n / 10;
        }
        if (sum == 1) {
            return true;
        } else {
            boolean happy = isHappy(sum);
            if (sum > 63) {
                cache.put(sum, happy);
            }
            return happy;
        }
    }

    @Test
    public void test() {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(25));
        System.out.println(happyNumber.isHappy(85));
        System.out.println(happyNumber.isHappy(29));
    }
}
