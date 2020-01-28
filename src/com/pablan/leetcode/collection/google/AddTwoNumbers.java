package com.pablan.leetcode.collection.google;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * Pablo's notes: How do you handle the case when one number is shorter than the other? It's math,
     * just make them 0
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int a = l1 != null ? l1.value : 0;
            int b = l2 != null ? l2.value : 0;

            int sum = carry + a + b;
            int value = (sum % 10);
            carry = (sum / 10);
            current.next = new ListNode(value);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
