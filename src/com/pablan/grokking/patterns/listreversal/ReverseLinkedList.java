package com.pablan.grokking.patterns.listreversal;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
