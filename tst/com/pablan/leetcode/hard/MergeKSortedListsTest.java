package com.pablan.leetcode.hard;

import com.pablan.leetcode.facebook.MergeKSortedLists;
import org.junit.Test;

public class MergeKSortedListsTest {
    
    @Test
    public void test() {
        MergeKSortedLists.ListNode list1 = new MergeKSortedLists.ListNode(1);
        list1.next = new MergeKSortedLists.ListNode(4);
        list1.next.next = new MergeKSortedLists.ListNode(5);

        MergeKSortedLists.ListNode list2 = new MergeKSortedLists.ListNode(1);
        list2.next = new MergeKSortedLists.ListNode(3);
        list2.next.next = new MergeKSortedLists.ListNode(4);

        MergeKSortedLists.ListNode list3 = new MergeKSortedLists.ListNode(2);
        list3.next = new MergeKSortedLists.ListNode(6);

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        MergeKSortedLists.ListNode result = mergeKSortedLists.mergeKLists(new MergeKSortedLists.ListNode[] {list1, list2, list3});
        System.out.println(result);
    }
}
