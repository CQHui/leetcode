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
    private Map<Integer, Boolean> cache = new HashMap<>();

    public HappyNumber() {
        cache.put(0, false);
        cache.put(1, true);
        cache.put(2, false);
        cache.put(3, false);
        cache.put(4, false);
        cache.put(25, false);
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
            if (sum > 5) {
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
