package com.qihui.medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenqihui
 * @date 5/5/21
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *  
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 */
public class InorderTraversal {

    /**
     *  Recursive solution
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            traversalNode(root, result);
        }
        return result;
    }

    public static void traversalNode(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            traversalNode(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            traversalNode(node.right, result);
        }
    }

    /**
     *  Iterative solution
     */
    public static List<Integer> inorderTraversalViaIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            stack.push(node);
        }
         while (!stack.isEmpty()) {
             node = stack.pop();
             result.add(node.val);
             if (node.right != null) {
                 node = node.right;
                 stack.push(node);
                 while (node.left != null) {
                     node = node.left;
                     stack.push(node);
                 }
             }

         }
         return result;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node3 = new TreeNode(1, null, node2);

        List<Integer> integers = inorderTraversalViaIterative(node3);
        System.out.println(integers);

    }
}
