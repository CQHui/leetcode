package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * Created by Elliott Chen on 2023/4/25 16:29
 */
public class NSum {

    public List<List<Integer>> twoSum(int[] nums, int target) {
        return nSum(nums, 2, target);
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        return nSum(nums, 3, target);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int target) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        return nSumTarget(nums, n, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (sum < target){
                    left ++;
                }else if (sum > target){
                    right --;
                } else {
                    List<Integer> num = List.of(nums[left], nums[right]);
                    ans.add(num);
                    while (left < right && nums[left] == leftValue) {
                        left ++;
                    }
                    while (left < right && nums[right] == rightValue) {
                        right --;
                    }
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> lists = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> sumTarget : lists) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(sumTarget);
                    ans.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i ++;
                }
            }
        }

        return ans;
    }



    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }


}
