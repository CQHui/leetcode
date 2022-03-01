package com.qihui.hard.linkedlist;

import org.junit.Test;

import java.util.*;

/**
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *  
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *  
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 * @author chenqihui
 * @date 2/28/22
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            listNode = combine(listNode, lists[i]);
        }
        return listNode;
    }

    public ListNode combine(ListNode head1, ListNode head2) {
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
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void test() {
        ListNode node00 = new ListNode(1);
        ListNode node01 = new ListNode(4);
        ListNode node02 = new ListNode(5);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(4);
        ListNode node20 = new ListNode(2);
        ListNode node21 = new ListNode(6);

        node00.next = node01;
        node01.next = node02;

        node10.next = node11;
        node11.next = node12;

        node20.next = node21;

        ListNode[] nodes = new ListNode[]{node00, node10, node20};
        ListNode listNode = mergeKLists(nodes);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(",");
            listNode = listNode.next;
        }
    }


}
