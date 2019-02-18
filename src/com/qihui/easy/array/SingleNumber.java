package com.qihui.easy.array;

import java.util.Arrays;

/**
 * @author chenqihui
 * @date 2018/11/2
 *
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if (nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumberAnswer(int[] nums) {
        int result = 0;
        for(int i:nums){
            result = result^i;
        }
        return result;
    }

}
