package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class PalindromeLinkedListTest {

    @Test
    public void test() {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + palindromeLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + palindromeLinkedList.isPalindrome(head));
    }
}
