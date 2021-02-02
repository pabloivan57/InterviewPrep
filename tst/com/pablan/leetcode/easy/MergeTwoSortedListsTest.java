package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.fastslow.ListNode;

import org.junit.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void test() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println(result);
    }
}
