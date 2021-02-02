package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    public ListNode merge(ListNode a, ListNode b) {
        if(a == null) {
            return b;
        }

        if(b == null) {
            return a;
        }

        ListNode result;
        if(a.value < b.value) {
            a.next = merge(a.next, b);
            result = a;
        } else {
            b.next = merge(a, b.next);
            result = b;
        }

        return result;
    }
}
