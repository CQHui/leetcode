package com.qihui.dynamic;

/**
 * @author chenqihui
 * @date 2018/12/8
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], thisSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (thisSum > 0) {
                thisSum += nums[i];
            } else {
                //如果前面的和小0，那么重新开始求和
                thisSum = nums[i];
            }
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }
}
