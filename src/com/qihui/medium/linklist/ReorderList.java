package com.qihui.medium.linklist;

import org.junit.Test;

import java.util.LinkedList;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *  
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        LinkedList<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }

        ListNode node = deque.pollFirst();
        head = node;
        boolean isHead = false;
        while (!deque.isEmpty()) {
            if (isHead) {
                node.next = deque.pollFirst();
            } else {
                node.next = deque.pollLast();
            }
            node = node.next;
            isHead = !isHead;
        }
        node.next = null;
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);
    }

}
