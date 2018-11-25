package com.qihui.tree;

/**
 * @author chenqihui
 * @date 2018/11/25
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
             return true;
        }
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode root, Long min, Long max) {
        boolean compareWithParent;

        if (root.left != null) {

            compareWithParent = root.left.val <= min || root.left.val >= max;

            if (root.left.val >= root.val || compareWithParent) {
                return false;
            }

            if (!isValidNode(root.left, min, (long) root.val)) {
                return false;
            }
        }
        if (root.right != null) {

            compareWithParent = root.right.val <= min || root.right.val >= max;

            if (root.right.val <= root.val  || compareWithParent) {
                return false;
            }
            if (!isValidNode(root.right, (long) root.val, max)) {
                return false;
            }
        }

        return true;
    }
}
