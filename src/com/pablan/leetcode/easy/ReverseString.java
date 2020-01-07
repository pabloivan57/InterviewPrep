package com.pablan.leetcode.easy;

public class ReverseString {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * You may assume all the characters consist of printable ascii characters.
     */
    public char[] reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;

        char aux;
        while(p1 < p2) {
            // shuffle
            aux = s[p1];
            s[p1] = s[p2];
            s[p2] = aux;

            // move pointers
            p1++;
            p2--;
        }

        return s;
    }
}
