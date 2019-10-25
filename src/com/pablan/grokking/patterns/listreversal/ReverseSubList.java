package com.pablan.grokking.patterns.listreversal;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class ReverseSubList {

    public ListNode reverse(ListNode head, int p, int q) {
        ListNode current = head;
        ListNode previous = null;

        for (int i = 0;  current != null && i < p - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;

        for(int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }

        lastNodeOfSubList.next = current;


        return head;
    }
}
