package com.dsa.LinkedList;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode prev = null;

        while(head != null) {
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }

        return prev;
    }
}
