package com.qihui.medium.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * iven the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Created by Elliott Chen on 2023/4/21 12:35
 */
public class BinaryTreeRightSideView {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return ans;
        }
        int depth = 1;
        dfs(root, depth);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (ans.size() < depth) {
            ans.add(node.val);
        }
        depth ++;

        dfs(node.right, depth);
        dfs(node.left, depth);
    }

    @Test
    public void test() {

        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);



        List<Integer> integers = rightSideView(node1);
        System.out.println(integers);

    }

}
