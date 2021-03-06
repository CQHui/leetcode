package com.qihui.medium.linklist;

import org.junit.Test;

/**
 * @author chenqihui
 * @date 2019/3/4
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode evenNode = head.next;
        ListNode resultNode = new ListNode(head.val);
        ListNode next = resultNode;
        while (head.next != null && head.next.next != null) {
            head = head.next.next;
            next.next = new ListNode(head.val);
            next = next.next;
        }

        if (evenNode != null) {
            next.next = new ListNode(evenNode.val);
            next = next.next;
        }


        while (evenNode != null && evenNode.next != null && evenNode.next.next != null) {
            evenNode = evenNode.next.next;
            next.next = new ListNode(evenNode.val);
            next = next.next;
        }
        return resultNode;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
/*        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/
        oddEvenList(node1);
    }

}
