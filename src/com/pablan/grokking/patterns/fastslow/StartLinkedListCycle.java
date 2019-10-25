package com.pablan.grokking.patterns.fastslow;

public class StartLinkedListCycle {

    public ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            int cycleLength;
            if (fast != null && slow.value == fast.value) {
                // found cycle
                cycleLength = calculateCycleLength(slow);
                ListNode result = findCycleStart(head, cycleLength);
                return result;
            }
        }

        return null;
    }

    private int calculateCycleLength(ListNode slow) {
        ListNode current = slow.next;

        // If next node is the same, that means we are in a self loop
        // That by default is 1
        int length = 1;
        while(current != null && current.value != slow.value) {
            current = current.next;
            length++;
        }

        return length;
    }

    private ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }

        while(slow.value != fast.value) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
