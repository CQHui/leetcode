package com.qihui.hard.treeandgraph;

import org.junit.Test;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *  
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *  
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 * @author chenqihui
 * @date 3/29/22
 */
public class FindOrder {
    Queue<Integer> queue = new LinkedList<>();
    int[] visited;
    List<List<Integer>> nodes;
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        nodes = new ArrayList<>(numCourses);
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> edges = nodes.get(prerequisite[0]);
            edges.add(prerequisite[1]);
        }

        for (int i = 0; i < nodes.size() && valid; i++) {
            List<Integer> node = nodes.get(i);
            dfs(node, i);
        }

        if(!valid) {
            return new int[]{};
        }

        int[] ans = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            ans[i] = queue.poll();
            i ++;
        }
        return ans;
    }

    public void dfs(List<Integer> node, int index) {
        if (visited[index] == 2) {
            return;
        }
        if (node == null || node.isEmpty()) {
            visited[index] = 2;
            queue.offer(index);
            return;
        }
        if (visited[index] == 1) {
            valid = false;
            return;
        }
        visited[index] = 1;
        for (int i = 0; i < node.size() && valid; i++) {
            dfs(nodes.get(node.get(i)), node.get(i));
        }
        visited[index] = 2;
        queue.offer(index);
    }

    @Test
    public void test() {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }
}
