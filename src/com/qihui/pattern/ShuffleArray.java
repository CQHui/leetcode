package com.qihui.pattern;

import org.junit.Test;

import java.util.*;

/**
 * @author chenqihui
 * @date 2018/12/12
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class ShuffleArray {
    int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        boolean[] flag = new boolean[nums.length];
        int[] shuffleNums = new int[nums.length];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length);
            if (flag[index]) {
                while(flag[index]) {
                    index = random.nextInt(nums.length);
                }
                shuffleNums[i] = nums[index];
                flag[index] = true;
            } else {
                shuffleNums[i] = nums[index];
                flag[index] = true;
            }
        }
        return shuffleNums;
    }

    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray(new int[]{0, 1, 2, 3, 4});
    }

}

