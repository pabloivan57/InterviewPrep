package com.pablan.grokking.patterns.fastslow;

public class CircularArrayLoop {

    /**
     * We are given an array containing positive and negative numbers.
     * Suppose the array contains a number ‘M’ at a particular index.
     * Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
     * You should assume that the array is circular which means two things:
     *
     * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
     * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
     * Write a method to determine if the array has a cycle.
     * The cycle should have more than one element and should follow one direction which means
     * the cycle should not contain both forward and backward movements.
     *
     * Example 1:
     *
     * Input: [1, 2, -1, 2, 2]
     * Output: true
     * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
     * Example 2:
     *
     * Input: [2, 2, -1, 2]
     * Output: true
     * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
     *
     */
    public boolean loopExists(int[] arr) {
        int slow = 0;
        int fast = 0;

        do {
            slow = getNextIndex(slow, arr);
            fast = getNextIndex(fast, arr);
            if(fast != -1) {
                fast = getNextIndex(fast,  arr);
            }
        } while(slow != -1 && fast != -1 && slow != fast);

        if(slow != -1 && slow == fast) {
            return true;
        }

        return false;
    }

    private int getNextIndex(int index, int[] arr) {
        int nextIndex = (index + arr[index]) % arr.length;
        if(nextIndex < 0) {
            nextIndex = nextIndex + arr.length;
        }

        if(index == nextIndex) {
            return -1;
        }

        return nextIndex;
    }
}
