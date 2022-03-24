package com.qihui.hard.treeandgraph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 *
 * @author chenqihui
 * @date 3/22/22
 */
public class MaxPathSum {
    List<Integer> maxes = new ArrayList<>();
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        dfs(root);
        return maxes.stream().max(Comparator.comparingInt(o -> o)).orElse(root.val);
    }

    public int dfs(TreeNode node) {
        int leftValue = 0;
        int rightValue = 0;
        int result = node.val;
        boolean leftFlag = false , rightFlag = false;
        if (node.left != null) {
            leftValue = dfs((node.left));
            result = Math.max(node.val, leftValue + node.val);
            leftFlag = true;
        }
        if (node.right != null) {
            rightValue = dfs((node.right));
            result = Math.max(result, rightValue + node.val);
            rightFlag = true;
        }

        int max = Math.max(node.val, leftValue + node.val + rightValue);
        if (rightFlag) {
            max = Math.max(max, rightValue);
            max = Math.max(max, node.val + rightValue);
        }
        if (leftFlag) {
            max = Math.max(max, leftValue);
            max = Math.max(max, node.val + leftValue);
        }
        maxes.add(max);
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(maxPathSum(node1));
    }
}
