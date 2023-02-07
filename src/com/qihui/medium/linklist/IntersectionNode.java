package com.qihui.medium.linklist;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author chenqihui
 * @date 5/4/21
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int aLength = 0;
        int bLength = 0;
        if (nodeA != null && nodeB != null) {
            while (true) {
                if (nodeA == nodeB) {
                    return nodeB;
                } else {
                    if (nodeB .next ==null) {
                        break;
                    } else {
                        bLength ++;
                        nodeB = nodeB.next;
                    }
                }
            }
            while (true) {
                if (nodeA .next == null) {
                    break;
                } else {
                    aLength ++;
                    nodeA = nodeA.next;
                }
            }
        } else {
            return null;
        }
        nodeA = headA;
        nodeB = headB;
        if (aLength > bLength) {
            int skip = aLength - bLength;
            while (skip > 0) {
                nodeA = nodeA.next;
                skip --;
            }
            while (nodeA != nodeB) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return nodeA;
        } else {
            int skip = bLength - aLength;
            while (skip > 0) {
                nodeB = nodeB.next;
                skip --;
            }
            while (nodeA != nodeB) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return nodeA;
        }
    }

    HashSet<ListNode> set = new HashSet<>();
    public ListNode getIntersectionNodeWithSet(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        if (headA != null) {
            if (!set.add(headA)) {
                return headA;
            }
        }

        if (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
        }

        return getIntersectionNode(headA == null ? null : headA.next, headB == null ? null : headB.next);
    }
}
