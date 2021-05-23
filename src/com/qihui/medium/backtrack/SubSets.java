package com.qihui.medium.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenqihui
 * @date 5/21/21
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique
 *
 */
public class SubSets {
    int offset = -1;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track, result);
        return result;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        result.add(new LinkedList<>(track));

        for (int i = 0; i < nums.length; i++) {
            if (offset >= i) {
                continue;
            }
            track.add(nums[i]);
            offset = i;
            backTrack(nums, track, result);
            track.removeLast();
            offset = i - 1;
        }
    }


    @Test
    public void test() {
        List<List<Integer>> permute = subsets(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
