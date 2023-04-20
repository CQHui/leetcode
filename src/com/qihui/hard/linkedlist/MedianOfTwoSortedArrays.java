package com.qihui.hard.linkedlist;

import org.junit.Test;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *  
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *  
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * Created by Elliott Chen on 2023/4/20 22:00
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = combineArrays(nums1, nums2);
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2.0d;
        } else {
            return nums[length / 2];
        }
    }

    private int[] combineArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2;
        }
        if (nums2.length == 0) {
            return nums1;
        }

        int[] nums= new int[nums1.length + nums2.length];
        int index = 0;

        int i = 0;
        int j = 0;
        boolean iOver = false;
        boolean jOver = false;

        while (index < nums.length) {
            while (!jOver && (nums1[i] > nums2[j] || iOver)) {
                nums[index] = nums2[j];
                index ++;
                if (j + 1 < nums2.length) {
                    j ++;
                } else {
                    jOver = true;
                    break;
                }
            }
            if (iOver) {
                continue;
            }
            nums[index] = nums1[i];
            index ++;
            if (i + 1 < nums1.length) {
                i ++;
            } else {
                iOver = true;
            }
        }

        return nums;
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{2, 3};
        int[] nums2 = new int[]{1};

        System.out.println(findMedianSortedArrays(nums1, nums2));


    }
}
