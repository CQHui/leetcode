package com.qihui.easy.tree;

import java.util.*;

/**
 * @author chenqihui
 * @date 2018/11/30
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> step = new ArrayDeque<>();
        step.add(root);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);
        return iteratoe(step, result);
    }

    private List<List<Integer>> iteratoe(Queue<TreeNode> step, List<List<Integer>> result) {
        List<Integer> stepResult = new ArrayList<>();
        int size = step.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = step.remove();
            if (treeNode.left != null) {
                stepResult.add(treeNode.left.val);
                step.add(treeNode.left);
            }
            if (treeNode.right != null) {
                stepResult.add(treeNode.right.val);
                step.add(treeNode.right);
            }
        }
        if (!stepResult.isEmpty()) {
            result.add(stepResult);
        }
        if (!step.isEmpty()) {
            iteratoe(step, result);
        }
        return result;
    }

}
