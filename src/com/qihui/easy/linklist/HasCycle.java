package com.qihui.easy.linklist;

/**
 * @author chenqihui
 * @date 2018/11/28
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
