package com.qihui.medium.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenqihui
 * @date 5/9/21
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 */
public class BuildTreeFromPreorderAndInorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        LinkedList<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toCollection(LinkedList::new));
        ArrayList<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toCollection(ArrayList::new));
        return getRootNode(preorderList, inorderList);
    }

    private static TreeNode getRootNode(LinkedList<Integer> preorder, ArrayList<Integer> inorder) {
        if (inorder == null || inorder.size() == 0) {
            return null;
        }
        Integer val = preorder.getFirst();
        TreeNode node = new TreeNode(val);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        boolean isLeft = true;
        for (Integer integer : inorder) {
            if (integer != node.val) {
                if (isLeft) {
                    left.add(integer);
                } else {
                    right.add(integer);
                }
            } else {
                isLeft = false;
            }
        }

        if (!isLeft) {
            preorder.remove(val);
        }
        TreeNode leftNode = getRootNode(preorder, left);
        TreeNode rightNode = getRootNode(preorder, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
