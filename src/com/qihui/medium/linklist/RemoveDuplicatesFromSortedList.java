package com.qihui.medium.linklist;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *  
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 * Created by Elliott Chen on 2023/4/24 20:48
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHeader = new ListNode(0);
        newHeader.next = head;

        ListNode node = head;
        ListNode previousNode = newHeader;

        boolean removed = false;
        while (node != null && node.next != null) {
            node = node.next;
            while (previousNode.next.val == node.val) {
                node = node.next;
                removed = true;
                if (node == null) {
                    break;
                }
            }
            if (!removed) {
                previousNode = previousNode.next;
            } else {
                previousNode.next = node;
                removed = false;
            }
        }
        return newHeader.next;
    }
}
