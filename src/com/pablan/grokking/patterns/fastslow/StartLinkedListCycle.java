package com.pablan.grokking.patterns.fastslow;


public class StartLinkedListCycle {

    /**
     * The trick is as follows
     * 1.- encounter cycle length
     * 2.- then move pointe cycle length times
     * 4.- at this point you should be cycleLength position but we're interested
     *     in n - cycleLength, or in other words the amount of jumps it takes from cycleLength pos to go
     *     back in the list, which you can match by moving head one by one until they match
     *     then return slow pointer
     */
    public ListNode findCycleStart(ListNode head) {
        int cycleLength = findCycleLength(head);

        ListNode current = head;
        for(int i = 0; i < cycleLength; i++) {
            current = current.next;
        }

        ListNode slow = head;
        ListNode fast = current;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /** The idea is as follows, once we encounter the intersection with slow and fast pointer,
     * we can count cycle length simply by moving the pointer until we encounter intersection again
     **/
    public int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode intersection = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                intersection = slow;
                break;
            }
        }

        int cycleLength = 1;
        ListNode current = intersection.next;
        while(current != intersection) {
            cycleLength++;
            current = current.next;
        }

        return cycleLength;
    }
}
