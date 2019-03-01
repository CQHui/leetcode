package com.qihui.medium.array;

/**
 * @author chenqihui
 * @date 2019/3/1
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                continue;
            }
            if (secondMin > nums[i] && nums[i] > min) {
                secondMin = nums[i];
            } else if (secondMin < nums[i]){
                return true;
            }
        }
        return false;
    }

}
