package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class StartLinkedListCycleTest {

    @Test
    public void test() {
        StartLinkedListCycle startLinkedListCycle = new StartLinkedListCycle();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next; // 6 -> 3
        System.out.println("LinkedList cycle start: " + startLinkedListCycle.findCycleStart(head).value); // should be 3

        head.next.next.next.next.next.next = head.next.next.next; // 6 -> 4
        System.out.println("LinkedList cycle start: " + startLinkedListCycle.findCycleStart(head).value); // should be 4

        head.next.next.next.next.next.next = head; // 6 -> 1
        System.out.println("LinkedList cycle start: " + startLinkedListCycle.findCycleStart(head).value); // should be 1
    }
}
