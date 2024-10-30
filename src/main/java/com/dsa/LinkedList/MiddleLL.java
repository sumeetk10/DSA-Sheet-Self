package com.dsa.LinkedList;

public class MiddleLL {
    public ListNode middleNode(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;

    }
}
