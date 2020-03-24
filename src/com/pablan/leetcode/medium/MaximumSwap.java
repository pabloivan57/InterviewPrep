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
