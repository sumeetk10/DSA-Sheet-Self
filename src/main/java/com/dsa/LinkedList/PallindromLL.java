package com.dsa.LinkedList;

public class PallindromLL {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode middle = middle(head);
        ListNode reversedNodeHead = reverse(middle.next);
        middle.next=null;

        while (head != null && reversedNodeHead != null) {
            if (head.val != reversedNodeHead.val)
                return false;
            head = head.next;
            reversedNodeHead = reversedNodeHead.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode forw = null;
        ListNode curr = head;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode middle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
