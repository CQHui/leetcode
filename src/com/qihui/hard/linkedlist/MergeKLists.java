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

        Map<Integer, ListNode> map = new TreeMap<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 1;
            } else {
                return o1 - o2;
            }
        });

        ListNode node;
        for (int i = 0; i < lists.length; i++) {
            node = lists[i];
            while (node != null) {
                map.put(node.val, node);
                node = node.next;
            }
        }

        Iterator<ListNode> iterator = map.values().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        ListNode ans = iterator.next();
        node = ans;
        while(iterator.hasNext()) {
            ListNode next = iterator.next();
            node.next = next;
            node = next;
        }
        return ans;
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
