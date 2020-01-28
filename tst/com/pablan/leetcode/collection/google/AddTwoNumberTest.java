package com.pablan.leetcode.collection.google;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class AddTwoNumberTest {

    @Test
    public void test() {
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode result = addTwoNumbers.addTwoNumbers(first, second);
        System.out.println(result); // should be 807
    }
}
