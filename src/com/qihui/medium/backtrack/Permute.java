package com.qihui.medium.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenqihui
 * @date 5/19/21
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 */
public class Permute {
    boolean[] flag;
    int depth = -1;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        ArrayList<Integer> track = new ArrayList<>(nums.length);
        flag = new boolean[nums.length];
        backTrack(nums, track, result);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (flag[i]) {
                continue;
            }
            track.add(num);
            flag[i] = true;
            depth ++;
            backTrack(nums, track, result);
            track.remove(depth);
            flag[i] = false;
            depth --;

        }
    }

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}


