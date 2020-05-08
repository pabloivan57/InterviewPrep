package com.pablan.leetcode.collection.google.medium;

import java.util.Stack;

public class ValidateStackSequences {

    /**
     * Given two sequences pushed and popped with distinct values,
     * return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
     *
     *
     *
     * Example 1:
     *
     * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * Output: true
     * Explanation: We might do the following sequence:
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * Example 2:
     *
     * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * Output: false
     * Explanation: 1 cannot be popped before 2.
     *
     * Pablo's notes: This  is tricky but  easy, simple for loop, you have the intuition for this one in place
     * simply push until you see a equal values in stack/top and popped[first], keep popping while this
     * is true but move the other pointer each time you pop. At the end both p1  & p2 should be at the end of
     * the  array, otherwise is not possible to push / pop in that sequence
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int poppedIndex = 0;
        for(int pushedIndex = 0; pushedIndex < pushed.length; pushedIndex++) {
            stack.push(pushed[pushedIndex]);

            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                poppedIndex++;
                stack.pop();
            }
        }

        return poppedIndex == pushed.length;
    }
}
