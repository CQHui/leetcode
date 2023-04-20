package com.qihui.easy.sortandsearch;


/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *  
 *
 */
public class BinarySearch {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int mid = (left + right) / 2;

        while (nums[mid] != target) {
            if (right == left || right - left == 1) {
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
                return -1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}
