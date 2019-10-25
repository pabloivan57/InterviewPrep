package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class RemoveNthNodeFromListTest {

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        RemoveNthNodeFromList removeNthNodeFromList = new RemoveNthNodeFromList();
        removeNthNodeFromList.removeNthFromEnd(one, 2);
    }
}
