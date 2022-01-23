package com.qihui.hard.arrayandstring;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *  
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *  
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int productOfNums = 1;
        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int productExceptZero = productOfNums;
                for (int j = i + 1; j < nums.length; j++) {
                    productExceptZero *= nums[j];
                    if (productExceptZero == 0) {
                        break;
                    }
                }
                productExceptSelf[i] = productExceptZero;
                productOfNums *= nums[i];
                break;
            }
            productOfNums *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                productExceptSelf[i] = productOfNums / nums[i];
            }
        }
        return productExceptSelf;
    }
}
