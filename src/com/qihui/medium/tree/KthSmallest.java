package com.qihui.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenqihui
 * @date 5/11/21
 *
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *  
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 *
 */
public class KthSmallest {
    int k;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        findKthSmallest(root);
        return result;
    }

    private void findKthSmallest(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            findKthSmallest(node.left);
        }
        if (k == 0) {
            return;
        }
        k--;
        if (k == 0) {
            result = node.val;
            return;
        }
        if (node.right != null) {
            findKthSmallest(node.right);
        }
    }
}
