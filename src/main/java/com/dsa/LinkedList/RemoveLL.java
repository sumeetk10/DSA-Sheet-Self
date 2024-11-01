package com.dsa.LinkedList;

public class RemoveLL {
    public ListNode removeElements(ListNode head, int val) {

        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr = prev;

        while(curr.next != null) {
            if(curr.next.val == val) {
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }

        return prev.next;
    }
}
