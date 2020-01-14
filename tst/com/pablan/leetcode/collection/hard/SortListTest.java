package com.pablan.leetcode.collection.hard;

import com.pablan.grokking.patterns.fastslow.ListNode;
import org.junit.Test;

public class SortListTest {

    @Test
    public void test() {
        SortList sortList = new SortList();

        // 4->2->1->3
        ListNode four = new ListNode(4);
        four.next = new ListNode(2);
        four.next.next = new ListNode(1);
        four.next.next.next = new ListNode(3);

        ListNode head = sortList.sortList(four);
        System.out.println(head);
    }
}
