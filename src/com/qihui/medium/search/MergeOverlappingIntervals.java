package com.qihui.medium.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chenqihui
 * @date 6/3/21
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *  
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *  
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */
public class MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b [0];
        });
        priorityQueue.addAll(Arrays.asList(intervals));
        ArrayList<int[]> result = new ArrayList<>(intervals.length);

        while (priorityQueue.peek() != null) {
            int[] first = priorityQueue.poll();
            result.add(mergeOrPoll(first, priorityQueue));
        }
        return result.toArray(new int[result.size()][2]);
    }

    private int[] mergeOrPoll(int[] first, PriorityQueue<int[]> priorityQueue) {
        if (priorityQueue.peek() != null) {
            int[] second = priorityQueue.peek();
            if (second!= null && first[1] > second[1]) {
                priorityQueue.poll();
                return mergeOrPoll(first, priorityQueue);
            }
            if (second!= null && first[1] >= second[0]) {
                int[] newNode = {first[0], second[1]};
                priorityQueue.poll();
                return mergeOrPoll(newNode, priorityQueue);
            }
        }
        return first;
    }

}
