package com.qihui.hard.treeandgraph;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 *
 * @author chenqihui
 * @date 3/18/22
 */
public class LowestCommonAncestor {
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private Stack<TreeNode> stackP = new Stack<>();
    private Stack<TreeNode> stackQ = new Stack<>();
    boolean stackPCompleted = false;
    boolean stackQCompleted = false;

    public TreeNode lowestCommonAncestorWithStack(TreeNode root, TreeNode p, TreeNode q) {
        dfsWithStack(root, p, q);
        HashSet<TreeNode> set = new HashSet<>(stackP);
        while (stackQ != null) {
            TreeNode pop = stackQ.pop();
            if (!set.add(pop)) {
                return pop;
            }
        }
        return null;
    }

    private void dfsWithStack(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (stackPCompleted && stackQCompleted)) {
            return;
        }
        if (!stackPCompleted) {
            stackP.push(root);
        }
        if (!stackQCompleted) {
            stackQ.push(root);
        }
        if (root.equals(p)) {
            stackPCompleted = true;
        }
        if (root.equals(q)) {
            stackQCompleted = true;
        }
        if (root.left != null) {
            dfsWithStack(root.left, p, q);
        }
        if (root.right != null) {
            dfsWithStack(root.right, p, q);
        }
        if (!stackPCompleted) {
            stackP.pop();
        }
        if (!stackQCompleted) {
            stackQ.pop();
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode node1 =  new TreeNode(3);
        TreeNode node2 =  new TreeNode(5);
        TreeNode node3 =  new TreeNode(1);
        TreeNode node4 =  new TreeNode(6);
        TreeNode node5 =  new TreeNode(2);
        TreeNode node6 =  new TreeNode(0);
        TreeNode node7 =  new TreeNode(8);
        TreeNode node8 =  new TreeNode(7);
        TreeNode node9 =  new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node5.left = node8;
        node5.right = node9;

        node3.left = node6;
        node3.right = node7;
        System.out.println(lowestCommonAncestorWithStack(node1, node2, node9).val);

    }
}
