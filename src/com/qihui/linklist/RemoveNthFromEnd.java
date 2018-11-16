package com.qihui.linklist;

/**
 * @author chenqihui
 * @date 2018/11/16
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            length ++;
            node = node.next;
        }
        node = head;
        int index = length - n;

        if (index == 0) {
            return node.next;
        } else if (index == length - 1) {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = null;
            return head;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }
}
