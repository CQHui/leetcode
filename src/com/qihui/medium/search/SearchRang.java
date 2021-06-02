package com.qihui.medium.search;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author chenqihui
 * @date 6/2/21
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *  
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class SearchRang {
    Integer left;
    Integer right;
    Integer length;
    int[] result = new int[]{-1, -1};
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return result;
        }
        left = 0;
        length = nums.length;
        right = length - 1;
        findTarget(nums, target);
        return result;
    }

    private void findTarget(int[]nums, int target) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            findTargetFromIndex(nums, target, mid);
        } else if (mid + 1 < length && nums[mid + 1] == target) {
            findTargetFromIndex(nums, target, mid + 1);
        } else if(nums[mid] < target && mid != left) {
            left = mid;
            findTarget(nums, target);
        } else if(nums[mid] > target && mid != right) {
            right = mid;
            findTarget(nums, target);
        }
    }

    private void findTargetFromIndex(int[]nums, int target, int index) {
        int temp = index;
        while (temp - 1 >= 0) {
            if(nums[temp - 1] == target) {
                temp --;
                continue;
            }
            break;
        }
        result[0] = temp;
        temp = index;
        while (temp + 1 < length) {
            if(nums[temp + 1] == target) {
                temp ++;
                continue;
            }
            break;
        }
        result[1] = temp;
    }

    @Test
    public void test() {
        int[] ints = searchRange(new int[]{1, 2, 3, 3,3,3,4,5,9}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
