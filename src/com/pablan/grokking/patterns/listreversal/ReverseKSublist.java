package com.pablan.grokking.patterns.listreversal;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class ReverseKSublist {

    public ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head, previous = null;

        while (true) {
            ListNode lastNodeOfPreviousStart = previous;
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSublist = current;
            ListNode next = null; // will be used to temporarily store the next node

            // reverse 'k' nodes
            for(int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the previous part
            if (lastNodeOfPreviousStart != null) {
                lastNodeOfPreviousStart.next = previous; // 'previous' is now the first node of the sub-list
            } else {
                // this means we are changing the first node (head) of the LinkedList
                head = previous;
            }

            // connect with the next part
            lastNodeOfSublist.next = current;

            if (current == null) { // break, if we've reached the end of the LinkedList
                break;
            }

            // prepare for the next sub-list
            previous = lastNodeOfSublist;
        }

        return head;
    }
}
