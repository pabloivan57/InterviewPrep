package com.pablan.leetcode.facebook;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // load the lists in minHeap
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode head = null;
        ListNode current = null;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if(current == null) {
                current = node;
                head = current;
            } else {
                current.next = node;
                current = current.next;
            }

            if(node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
