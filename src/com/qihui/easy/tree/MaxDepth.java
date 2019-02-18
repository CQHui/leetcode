package com.qihui.easy.tree;

/**
 * @author chenqihui
 * @date 2018/11/22
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        return depth(root, depth);
    }

    private int depth(TreeNode node, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        if (node.left != null) {
            leftDepth = depth(node.left, depth + 1);
        }
        if (node.right != null) {
            rightDepth = depth(node.right, depth + 1);
        }

        return leftDepth >= rightDepth ? leftDepth : rightDepth;
    }
}
