package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void test() {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = a.next.next;


        ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(a, b);
        System.out.print(result);
    }
}
