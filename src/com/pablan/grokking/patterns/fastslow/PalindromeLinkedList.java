package com.pablan.grokking.patterns.fastslow;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode copyHeadSecondHalf = headSecondHalf;

        ListNode current = head;
        while(current != headSecondHalf) {
            if (current.value != headSecondHalf.value) {
                return false;
            }
            current = current.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf);

        return true;
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
