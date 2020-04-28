package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class RearrangeLinkedListTest {

    @Test
    public void test() {
        RearrangeLinkedList rearrangeLinkedList = new RearrangeLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        rearrangeLinkedList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
