package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.fastslow.ListNode;

public class IntersectionOfTwoLinkedLists {


    /**
     *  Pablo's notes: You can't just reverse the list because in this
     *  problem another list literally points to the node of another list
     *
     *  a1 -> a2 \
     *             \
     *               c2 -> c3 -> c4
     *             /
     *  b1 -> b2 /
     *
     * If you reverse a... you're messing up with b
     * c4 -> c3 -> c2-> a2 -> a1
     *
     * b1 -> b2
     *
     * Therefore the TRICK here is to move 2 pointers until they reach the same point together. BUT
     * when you reach end of a you move the pointer to b and viceversa. That works because when you move pointer
     * from list A to b... you make up for the extra elements on the bigger list.
     *
     * Look at this example:
     *
     * Visualization of this solution:
     * Case 1 (Have Intersection & Same Len):
     *
     *        a
     * A:     a1 → a2 → a3
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *        b
     *             a
     * A:     a1 → a2 → a3
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *             b
     *                  a
     * A:     a1 → a2 → a3
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *                  b
     * A:     a1 → a2 → a3
     *                    ↘ a
     *                      c1 → c2 → c3 → null
     *                    ↗ b
     * B:     b1 → b2 → b3
     * Since a == b is true, end loop while(a != b), return the intersection node a = c1.
     *
     * Case 2 (Have Intersection & Different Len):
     *
     *             a
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *        b
     *                  a
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *             b
     * A:          a1 → a2
     *                    ↘ a
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *                  b
     * A:          a1 → a2
     *                    ↘      a
     *                      c1 → c2 → c3 → null
     *                    ↗ b
     * B:     b1 → b2 → b3
     * A:          a1 → a2
     *                    ↘           a
     *                      c1 → c2 → c3 → null
     *                    ↗      b
     * B:     b1 → b2 → b3
     * A:          a1 → a2
     *                    ↘                a = null, then a = b1
     *                      c1 → c2 → c3 → null
     *                    ↗           b
     * B:     b1 → b2 → b3
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗                b = null, then b = a1
     * B:     b1 → b2 → b3
     *        a
     *             b
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *             a
     *                  b
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *                  a
     * A:          a1 → a2
     *                    ↘ b
     *                      c1 → c2 → c3 → null
     *                    ↗ a
     * B:     b1 → b2 → b3
     * Since a == b is true, end loop while(a != b), return the intersection node a = c1.
     *
     * Case 3 (Have No Intersection & Same Len):
     *
     *        a
     * A:     a1 → a2 → a3 → null
     * B:     b1 → b2 → b3 → null
     *        b
     *             a
     * A:     a1 → a2 → a3 → null
     * B:     b1 → b2 → b3 → null
     *             b
     *                  a
     * A:     a1 → a2 → a3 → null
     * B:     b1 → b2 → b3 → null
     *                  b
     *                       a = null
     * A:     a1 → a2 → a3 → null
     * B:     b1 → b2 → b3 → null
     *                       b = null
     * Since a == b is true (both refer to null), end loop while(a != b), return a = null.
     *
     * Case 4 (Have No Intersection & Different Len):
     *
     *        a
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *        b
     *             a
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *             b
     *                  a
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *                  b
     *                       a
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *                       b = null, then b = a1
     *        b                   a = null, then a = b1
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *             b
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *        a
     *                  b
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *             a
     *                       b
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *                  a
     *                            b = null
     * A:     a1 → a2 → a3 → a4 → null
     * B:     b1 → b2 → b3 → null
     *                       a = null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a.next == null ? headB : a.next;
            b = a.next == null ? headA : b.next;
        }

        return a;
    }
}
