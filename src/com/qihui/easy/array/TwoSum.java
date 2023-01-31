package com.qihui.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqihui
 * @date 2018/11/9
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        while(i < nums.length) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                j++;
            }
            i++;
        }
        return new int[]{0, 0};
    }

    public int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer number = map.get(target - nums[i]);
            if (number != null && i != number) {
                return new int[]{i, number};
            }
        }
        return new int[]{};
    }
}
