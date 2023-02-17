package com.qihui.medium.dynamic;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 6/11/21
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //dp[i]=max(dp[j])+1, 0≤j<i and num[j]<num[i]
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int length = getLength(i, nums, dp);
            max = Math.max(max, length);
            dp[i] = length;
        }
        return max;
    }

    private int getLength(int num, int[] nums, int[] dp) {
        int max = 1;
        for (int i = 0; i < num; i++) {
            if (nums[i] < nums[num]) {
                int length = dp[i] + 1;
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public int lengthOfLISV1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxDp = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxDp = Math.max(maxDp, dp[i]);
        }
        return maxDp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLISV1(nums));
    }
}
