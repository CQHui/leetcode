package com.qihui.medium.linklist;

import org.junit.Test;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *  
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *  
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }
        if (left == 1) {
            ListNode node0 = new ListNode(0);
            node0.next = head;
            head = node0;
            left ++;
            right ++;
        }
        int index = 1;
        ListNode leftNode = head;
        ListNode leftPrev = null;


        while (index < left) {
            leftPrev = leftNode;
            leftNode = leftNode.next;
            index ++;
        }
        leftNode.next = reverse(leftPrev, null, leftNode, right - left);
        return head.next;
    }

    private ListNode reverse(ListNode firstNode, ListNode prev, ListNode cur, int index) {
        if (index == 0) {
            ListNode temp = cur.next;
            firstNode.next = cur;
            cur.next = prev;
            return temp;
        }
        ListNode next = reverse(firstNode, cur, cur.next, index - 1);
        cur.next = prev;
        return next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseBetween(node1, 2, 4));
    }
}
