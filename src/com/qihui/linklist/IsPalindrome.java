package com.qihui.linklist;

/**
 * @author chenqihui
 * @date 2018/11/23
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int depth = depth(head);
        int split = depth % 2 == 0 ? depth / 2 : depth / 2 + 1;
        ListNode lastNode = head;
        ListNode temp = head;
        for (int i = 0; i < split; i++) {
            lastNode = lastNode.next;
            if (i == depth / 2 - 1) {
                temp.next = null;
            } else if (i < depth / 2 - 1) {
                temp = temp.next;
            }
        }

        return isEqual(head, reverseNode(lastNode));

    }

    private boolean isEqual(ListNode node, ListNode lastNode) {
        if (node.val != lastNode.val) {
            return false;
        }
        while (node.next != null) {
            return isEqual(node.next, lastNode.next);
        }
        return true;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            // 断开当前要插入的节点
            head.next = nextNode.next;//
            // 将nextNode头插到nextHead之后
            nextNode.next = newHead.next;
            newHead.next = nextNode;
            // 继续下一个节点
            nextNode = head.next;
        }
        return newHead.next;
    }

    private int depth(ListNode node) {
        if (node == null) {
            return 0;
        }
        int depth = 1;
        while (node.next != null) {
            depth ++;
            node = node.next;
        }
        return depth;
    }

}
