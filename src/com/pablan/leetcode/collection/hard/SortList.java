package com.pablan.leetcode.collection.hard;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class SortList {

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example 1:
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     *
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     *
     * Pablo's notes: This is merge sort implementation for linkedLists
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        // base case, if there is just one element
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode next = middle.next;

        middle.next = null;
        ListNode a = mergeSort(head);
        ListNode b = mergeSort(next);

        return merge(a, b);
    }

    private ListNode merge(ListNode a, ListNode b) {
        if(a == null) {
            return b;
        }

        if(b == null) {
            return a;
        }

        ListNode result;
        if(a.value < b.value) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }

        return result;
    }

    private ListNode findMiddle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
