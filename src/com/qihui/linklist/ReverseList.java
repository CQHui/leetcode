package com.qihui.linklist;

/**
 * @author chenqihui
 * @date 2018/11/19
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        if (node == null) {
            return null;
        }
        return reverNode(node, null);
    }

    private ListNode reverNode(ListNode node, ListNode preNode) {
        ListNode temp = node.next;
        node.next = preNode;
        if (temp != null) {
            return reverNode(temp, node);
        }
        return node;
    }

}
