package com.qihui.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenqihui
 * @date 5/7/21
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        boolean leftToRight = true;

        Stack<TreeNode> from = new Stack<>();
        Stack<TreeNode> to = new Stack<>();
        TreeNode node = root;
        from.push(node);

        while (!from.isEmpty() || !to.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            if (leftToRight) {
                while(!from.isEmpty()) {
                    node = from.pop();
                    row.add(node.val);
                    if (node.left != null) {
                        to.push(node.left);
                    }
                    if (node.right != null) {
                        to.push(node.right);
                    }
                }
                result.add(row);
                leftToRight = false;
            } else {
                while(!to.isEmpty()) {
                    node = to.pop();
                    row.add(node.val);
                    if (node.right != null) {
                        from.push(node.right);
                    }
                    if (node.left != null) {
                        from.push(node.left);
                    }
                }
                result.add(row);
                leftToRight = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(15, null, null);
        TreeNode node2 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9, null, null);
        TreeNode node5 = new TreeNode(3, node4, node3);


        List<List<Integer>> lists = zigzagLevelOrder(node5);
        System.out.println(lists);

    }
}
