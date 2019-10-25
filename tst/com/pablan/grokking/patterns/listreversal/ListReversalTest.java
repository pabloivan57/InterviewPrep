package com.pablan.grokking.patterns.listreversal;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class ListReversalTest {

    @Test
    public void test() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
