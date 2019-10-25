package com.pablan.grokking.patterns.listreversal;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class ReverseSublistTest {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseSubList reverseSubList = new ReverseSubList();
        ListNode result = reverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
