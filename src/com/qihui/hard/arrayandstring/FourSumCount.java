package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *  
 *
 * Example 1:
 *
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * Example 2:
 *
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 *
 * @author chenqihui
 * @date 2/1/22
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum12 = new HashMap<>(131072);

        for (int item : nums1) {
            for (int value : nums2) {
                int sum = item + value;
                sum12.put(sum, sum12.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int item : nums3) {
            for (int value : nums4) {
                Integer countFrom12 = sum12.getOrDefault(-(item + value), 0);
                count += countFrom12;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{1,-2,3};
        int[] nums3 = new int[]{-1,2,3};
        int[] nums4 = new int[]{-1,2,3};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
