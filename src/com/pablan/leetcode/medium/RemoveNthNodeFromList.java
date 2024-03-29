package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class RemoveNthNodeFromList {

    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     *
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     *
     * Given n will always be valid.
     *
     * Pablo's notes: The idea is to always keep n distance between the nodes so that when you reach
     * end the other pointer will be n nodes away
     *
     * Using a dummy as head is crafted to deal with the [1], 1 use case which asks to remove
     * the first element. But because you must have them n spaces away this will turn to NPEs
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
