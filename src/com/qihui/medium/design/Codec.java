package com.qihui.medium.design;

import com.qihui.medium.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenqihui
 * @date 6/13/21
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
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
 * Input: root = [1,2]
 * Output: [1,2]
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        addNodes(queue, sb);
        sb.replace(sb.length() - 1, sb.length(), "]");

        while (true) {
            int last = sb.lastIndexOf("null,null]");
            if (last != -1) {
                sb.replace(last - 1, sb.length() - 1, "");
                continue;
            }
            break;
        }
        return sb.toString();
    }

    private void addNodes(Queue<TreeNode> queue, StringBuilder sb) {
        while (queue.peek() != null) {
            TreeNode poll = queue.poll();
            if (poll.val == 1001) {
                sb.append("null");
                sb.append(',');
                continue;
            }
            sb.append(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            } else {
                queue.add(new TreeNode(1001));
            }
            if (poll.right != null) {
                queue.add(poll.right);
            } else {
                queue.add(new TreeNode(1001));
            }
            sb.append(',');
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 2 || data.equals("[]")) {
            return null;
        }
        char[] chars = data.toCharArray();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean gate = false;
        TreeNode root = new TreeNode();
        StringBuilder sb = new StringBuilder();

        int i = 1;
        sb.append(chars[i]);
        while (chars[i + 1] != ',' && chars[i + 1] != ']') {
            sb.append(chars[i + 1]);
            i ++;
        }
        root.val = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        queue.add(root);
        for (i = i + 1;i < chars.length; i++) {
            switch (chars[i]) {
                case ',':
                    break;
                case ']':
                    break;
                case 'n':
                    i = i + 3;
                    if (!gate) {
                        gate = true;
                    } else {
                        queue.poll();
                        gate = false;
                    }
                    break;
                default:
                    sb.append(chars[i]);
                    while (chars[i + 1] != ',' && chars[i + 1] != ']') {
                        sb.append(chars[i + 1]);
                        i ++;
                    }
                    int value = Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                    TreeNode node = new TreeNode(value);
                    queue.add(node);
                    if (!gate) {
                        TreeNode parent = queue.peek();
                        parent.left = node;
                        gate = true;
                    } else {
                        TreeNode parent = queue.poll();
                        parent.right = node;
                        gate = false;
                    }
            }
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(2, node3, node4);
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(node5));
        System.out.println(ser.serialize(ans));
    }
}
