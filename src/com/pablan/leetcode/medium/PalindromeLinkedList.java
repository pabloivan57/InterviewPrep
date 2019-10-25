package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current = head;
        ListNode tail = reverse(slow);

        while(current != null && tail != null) {
            if(current.value != tail.value) {
                return false;
            }

            current = current.next;
            tail = tail.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current  = node;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
