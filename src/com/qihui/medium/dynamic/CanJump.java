package com.qihui.medium.dynamic;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 6/7/21
 *
 * 跳跃游戏
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        //a + nums[a] > a
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            int indexJump = i + nums[i];
            if (indexJump > max) {
                max = indexJump;
                if (max > nums.length) {
                    return true;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,0,8,2,0,0,1};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}
