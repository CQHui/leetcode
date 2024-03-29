package com.qihui.easy.linklist;

/**
 * @author chenqihui
 * @date 2018/11/21
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode node = result;
        do {
            while (l2 != null) {
                if (l1 == null || l2.val <= l1.val) {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                    node = node.next;
                } else {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                    node = node.next;
                }
            }
            if (l1 != null) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;
            }
        } while (l1 != null);
        return result;
    }

    public ListNode mergeTwoListWithRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.next == null && list2.next == null) {
            if (list1.val < list2. val) {
                list1.next = list2;
                return list1;
            } else {
                list2.next = list1;
                return list2;
            }
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoListWithRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListWithRecursion(list1, list2.next);
            return list2;
        }
    }
}
