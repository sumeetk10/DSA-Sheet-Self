package com.dsa.LinkedList;

public class AddTwoLL {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        int sum = 0;
        Node head1 = reverse(num1);
        Node head2 = reverse(num2);

        Node helper = new Node(0);
        Node result = helper;

        while(head1 != null || head2 != null || sum != 0){
            sum += (head1 == null ? 0 : head1.data ) + (head2 == null ? 0 : head2.data);

            helper.next = new Node(sum%10);
            sum = sum/10;
            helper = helper.next;

            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }

        Node add = reverse(result.next);

        return add;


    }

    static Node reverse(Node n1){

        Node prev = null;

        while(n1 != null) {
            Node dummy = n1.next;
            n1.next = prev;
            prev = n1;
            n1 = dummy;
        }

        return prev;
    }
}
