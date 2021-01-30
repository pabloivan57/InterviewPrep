package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode reverseA = reverse(headA);
        ListNode reverseB = reverse(headB);

        ListNode prevA = null;
        while(reverseA != reverseB) {
            prevA = reverseA;
            reverseA = reverseA.next;
            reverseB = reverseB.next;
        }

        return prevA;
    }

    private ListNode reverse(ListNode head) {
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
