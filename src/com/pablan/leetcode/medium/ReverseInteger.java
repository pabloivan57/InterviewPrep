package com.pablan.leetcode.medium;

public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     * Example 2:
     *
     * Input: -123
     * Output: -321
     * Example 3:
     *
     * Input: 120
     * Output: 21
     *
     */
    public int reverse(int x) {
        int reverse = 0;

        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while(x > 10) {
            // add the last element and multiply por decenas, centenas, etc
            reverse = (reverse * 10) + (x % 10);
            x = x / 10;
        }

        reverse = (reverse * 10) + x;
        return reverse * sign;
    }
}
