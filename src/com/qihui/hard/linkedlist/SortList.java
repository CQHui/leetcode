package com.qihui.hard.linkedlist;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *  
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *  
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * @author chenqihui
 * @date 3/1/22
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode after = slow.next;
        slow.next = null;
        head = sortList(head);
        after = sortList(after);
        return combine(head, after);
    }

    public SortList.ListNode combine(SortList.ListNode head1, SortList.ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val > head2.val) {
            return combine(head2, head1);
        }
        ListNode tmp;
        ListNode pre = head1;
        ListNode cur = head2;
        while (pre.next != null && cur != null) {
            if (pre.next.val <= cur.val) {
                pre = pre.next;
                continue;
            }
            tmp = pre.next;
            pre.next = cur;
            cur = cur.next;
            pre.next.next = tmp;
        }
        if (cur != null) {
            pre.next = cur;
        }
        return head1;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    @Test
    public void test() {
        SortList.ListNode node0 = new SortList.ListNode(1);
        SortList.ListNode node1 = new SortList.ListNode(4);
        SortList.ListNode node2 = new SortList.ListNode(2);
        SortList.ListNode node3 = new SortList.ListNode(3);


        node0.next = node1;
        node1.next = node2;
        node2.next = node3;


        SortList.ListNode listNode = sortList(node0);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(",");
            listNode = listNode.next;
        }
    }
}
