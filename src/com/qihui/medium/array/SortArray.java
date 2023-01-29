package com.qihui.medium.array;

import org.junit.Test;

/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    public void sortArray(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int partitionIndex = partition(nums, left, right);

        sortArray(nums, left, partitionIndex - 1);

        sortArray(nums, partitionIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int pivot = (left + right) / 2;
        swap(nums, left, pivot);
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[left] > nums[i]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        int[] nums= {5, 1, 1, 2, 0, 0};
        sortArray(nums);
    }
}
