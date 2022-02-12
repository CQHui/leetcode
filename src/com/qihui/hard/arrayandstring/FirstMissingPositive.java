package com.qihui.hard.arrayandstring;

import org.junit.Test;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *  
 *
 *
 * @author chenqihui
 * @date 2/12/22
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] newNums = nums.clone();
        for (int i = 0; i < length; i++) {
            if(nums[i] > 0 && nums[i] <= length) {
                newNums[nums[i] - 1] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            if (newNums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,1};
        System.out.println(firstMissingPositive(nums));
    }

}
