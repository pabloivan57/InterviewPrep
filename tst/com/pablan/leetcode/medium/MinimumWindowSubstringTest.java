package com.pablan.leetcode.medium;

import org.junit.Test;

public class MinimumWindowSubstringTest {

    @Test
    public void test() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC")); // should be BANC
    }
}
