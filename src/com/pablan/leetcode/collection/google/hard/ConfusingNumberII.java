package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConfusingNumberII {

    /**
     * We can rotate digits by 180 degrees to form new digits.
     * When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively.
     * When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
     *
     * A confusing number is a number that when rotated 180 degrees becomes a different
     * number with each digit valid.(Note that the rotated number can be greater than the original number.)
     *
     * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
     *
     * Example 1:
     *
     * Input: 20
     * Output: 6
     * Explanation:
     * The confusing numbers are [6,9,10,16,18,19].
     * 6 converts to 9.
     * 9 converts to 6.
     * 10 converts to 01 which is just 1.
     * 16 converts to 91.
     * 18 converts to 81.
     * 19 converts to 61.
     *
     * Example 2:
     *
     * Input: 100
     * Output: 19
     * Explanation:
     * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
     *
     * Pablo's notes: The intuition of this problem is as follows. How do you construct Confusing numbers?
     *
     * 1.- Add 0, 1, 6, 8 or 9 to each previously achieve number. Let's start from 0.
     *
     * 0 + 0 / 0 == 0 ? Not confusing
     * 0 + 1 / 1 == 1 ? Not confusing
     * 0 + 6 / 6 == 9 ? Confusing
     * 0 + 8 / 8 == 8 ? Not confusing
     * 0 + 9 / 9 == 6 Confusing
     *
     * Difference is, we might have a confusing if we keep going and check what would happen with the resulting numbers.
     * Example:
     * 1 + 0 / 10 != 01 ? Confusing
     * 1 + 1 / 11 == 11 Not confusing
     * 1 + 6 / 16 != 61 Confusing
     * .
     * .
     * We stop at N
     * 11 + 1 / 111 > 20. We stop
     *
     * So we start with 0. at each level we try 0, 1, 6, 8, 9 and we keep going recursively until we hit a N
     * and at each stage we check for confusing number
     *
     * 2. - How to we check for confusing number?
     * 68 == 89
     * 89 == 8 * 10 + 9 --> How did we get to 9? well we now that 6 maps to 9 and we worked backwards from 68
     *                                                                                                      ^
     *  basically num % 10, take that num, flip it and multiply by 10
     */
    Map<Integer, Integer> mappings;
    int result = 0;

    public ConfusingNumberII() {
        mappings = new HashMap<>();
        mappings.put(0, 0);
        mappings.put(1, 1);
        mappings.put(6, 9);
        mappings.put(8, 8);
        mappings.put(9, 6);
    }

    public int confusingNumberII(int N) {
        result = 0;

        helper(0, N);

        return result;
    }

    private void helper(int current, int N) {
        if(isConfusing(current)) {
            result++;
        }

        for(Integer key : mappings.keySet()) {
            int nextConfusing = current * 10 + key;
            // we already explored 0 in this level. If we do 0 * 0 + anything we will explore the same
            // that's why we skip 0, to save a couple cycles
            if(nextConfusing < N && nextConfusing != 0) {
                helper(nextConfusing, N);
            }
        }
    }

    private boolean isConfusing(int number) {
        // number is confusing if flipped is different than the original
        // example: 69 != 96, 10 != 01
        int flipped = 0;
        while(number > 0) {
            int lastNumber = number % 10;
            int mirroredNumber = mappings.get(lastNumber);
            flipped = flipped * 10 + mirroredNumber;
            number = number / 10;
        }

        return flipped != number;
    }
}
