package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class MinimumWindowSubsequenceTest {

    @Test
    public void test() {
        MinimumWindowSubsequence minimumWindowSubsequence = new MinimumWindowSubsequence();
        System.out.println(minimumWindowSubsequence.minWindow("abcdebdde", "bde")); // should be bcde
    }
}
