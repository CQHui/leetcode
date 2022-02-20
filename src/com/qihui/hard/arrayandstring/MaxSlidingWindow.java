package com.qihui.hard.arrayandstring;

import org.junit.Test;

import java.util.*;

/**
 *  *
 *  * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *  *
 *  * Return the max sliding window.
 *  *
 *  *  
 *  *
 *  * Example 1:
 *  *
 *  * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *  * Output: [3,3,5,5,6,7]
 *  * Explanation:
 *  * Window position                Max
 *  * ---------------               -----
 *  * [1  3  -1] -3  5  3  6  7       3
 *  *  1 [3  -1  -3] 5  3  6  7       3
 *  *  1  3 [-1  -3  5] 3  6  7       5
 *  *  1  3  -1 [-3  5  3] 6  7       5
 *  *  1  3  -1  -3 [5  3  6] 7       6
 *  *  1  3  -1  -3  5 [3  6  7]      7
 *  * Example 2:
 *  *
 *  * Input: nums = [1], k = 1
 *  * Output: [1]
 *  *  
 *  *
 *  * Constraints:
 *  *
 *  * 1 <= nums.length <= 105
 *  * -104 <= nums[i] <= 104
 *  * 1 <= k <= nums.length
 *
 * @author chenqihui
 * @date 2/20/22
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();

        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res[j++] = queue.max();
                queue.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    static class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
