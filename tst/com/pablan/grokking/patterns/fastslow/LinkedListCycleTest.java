package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class LinkedListCycleTest {

    @Test
    public void test() {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + linkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + linkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + linkedListCycle.hasCycle(head));
    }
}
