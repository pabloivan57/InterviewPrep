package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class PalindromeLinkedListTest {

    @Test
    public void test() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        //System.out.println("Is palindrome: " + new PalindromeLinkedList().isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + new PalindromeLinkedList().isPalindrome(head));
    }
}
