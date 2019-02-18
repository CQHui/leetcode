package com.qihui.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqihui
 * @date 2019/2/18
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        //确保nums[i]非正数
        while (i < nums.length && nums[i] <= 0) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = nums.length - 1;
            //确保nums[j]非负数
            while(nums[j] >= 0 && j > i) {
                if (j <  nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                int sum = nums[i] + nums[j];
                //确保k为i和j之间的数
                if (sum + nums[i] > 0 || sum + nums[j] < 0) {
                    j--;
                    continue;
                }
                //二分法查找
                Integer k = binSearch(nums, -sum, i + 1, j - 1);
                if (k == null) {
                    j--;
                    continue;
                } else {
                    result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                }
                j--;
            }
            i++;
        }
        return result;
    }

    /**
     * 二分法查找
     * @param srcArray
     * @param key
     * @param start 包含
     * @param end 不包含
     * @return
     */
    public Integer binSearch(int srcArray[], int key, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return null;
    }
}
