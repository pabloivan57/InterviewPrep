package com.pablan.grokking.patterns.fastslow;

public class RearrangeLinkedList {

    public void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p1 = head;
        ListNode p2 = reverse(slow);

        boolean p1Turn = true;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (p1 != null && p2 != null) {
            if(p1Turn) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }

            current = current.next;
            p1Turn = !p1Turn;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
