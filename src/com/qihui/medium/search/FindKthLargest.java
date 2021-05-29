package com.qihui.medium.search;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author chenqihui
 * @date 5/29/21
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *  
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int kth = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.add(nums[i]);
                if (i == k - 1) {
                    kth = queue.peek();
                }
            } else if (nums[i] > kth) {
                queue.poll();
                queue.add(nums[i]);
                kth = queue.peek();
            }
        }
        return queue.poll();
    }

    @Test
    public void test() {
        int value = findKthLargest(new int[]{5,3,1,1,1,3,73,1}, 2);
        System.out.println(value);
    }
}
