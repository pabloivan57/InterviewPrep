package com.pablan.leetcode.medium;

public class MaximumSwap {

    /**
     * Given a non-negative integer,
     * you could swap two digits at most once to get the maximum valued number.
     * Return the maximum valued number you could get
     *
     * Example 1:
     *
     * Input: 2736
     * Output: 7236
     * Explanation: Swap the number 2 and the number 7.
     * Example 2:
     *
     * Input: 9973
     * Output: 9973
     * Explanation: No swap.
     *
     * When resolving this think of the following
     * 1.- Take index 0 (the most important)
     * 2.- Look for the max number at the right of 0
     * 3.- Swap it
     *
     * Now, why we just don't find the max and then swap it with 0. Because for this one
     * 98863 it wouldn't work. You can in the case there is no max to the right side keep doing
     * it until there is one max but then that could be quadratic. A better approach is this one
     * take note of the indexes of each number and then go from max to min checking if there is something
     * more than current number with index > current index
     *
     * Pablo's better notes: Basically we are making this O(n) by making the worst case scenario O(n) * O(9)
     * which is technically O(n). Anyways, think of it this way;
     *
     * FIRST, let's note where each number shows up
     *
     * 2 -> index 0
     * 7 -> index 1
     * 3 -> index 2
     * 6 -> index 3
     *
     * Then we go from 9 to 0 and compare with the number that is in the first position. If index of 9 is
     * more than index of 0 then swap. Otherwise let's check the index of 8, is it more than index of 0? swap.
     * For example:
     *
     * 2 7 3 6  --> number
     * 0 1 2 3  --> index
     *
     * Let's check from 9 to 0. index of 9? We don't have anything... cool let's keep going. Index of 8? We
     * don't have anything... let's keep going. Index of 7? Yes, I see we have 1. Is 1 more than 0 which I'm right
     * now? Yes, then swap it. We are done
     */
    public int maximumSwap(int number) {
        char[] digits = Integer.toString(number).toCharArray();
        int[] index = new int[10];

        for(int i = 0; i < digits.length; i++) {
            index[digits[i] - '0'] = i;
        }

        for(int i = 0; i < digits.length; i++) {
            for(int j = 9; j > digits[i] - '0'; j--) {
                if(index[j] > i) {
                    swap(digits, i, index[j]);
                    // you can only swap at most once
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return Integer.valueOf(new String(digits));
    }

    private void swap(char[] numbers, int i, int j) {
        Character aux = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = aux;
    }
}
