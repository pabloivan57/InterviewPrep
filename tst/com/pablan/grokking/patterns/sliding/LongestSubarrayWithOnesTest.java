package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class LongestSubarrayWithOnesTest {

    @Test
    public void test() {
        LongestSubarrayWithOnes longestSubarrayWithOnes = new LongestSubarrayWithOnes();
        System.out.println(longestSubarrayWithOnes.findLength(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)); // should be 6
        System.out.println(longestSubarrayWithOnes.findLength(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3)); // should be 9
    }
}
