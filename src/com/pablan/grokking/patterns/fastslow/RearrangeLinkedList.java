package com.pablan.grokking.patterns.fastslow;

public class RearrangeLinkedList {

    public void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;

        while(headFirstHalf != null && headSecondHalf != null) {
            ListNode tmp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = tmp;

            tmp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = tmp;
        }

        if(headFirstHalf != null)
            headFirstHalf.next = null;
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
