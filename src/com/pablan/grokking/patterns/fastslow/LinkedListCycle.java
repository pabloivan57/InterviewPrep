package com.pablan.grokking.patterns.fastslow;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // May have reached the end of the list by this point
            if(fast != null && (fast.value == slow.value)) {
                return true;
            }
        }

        return false;
    }
}
