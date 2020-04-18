package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class LongestSubstringWithKReplacementsTest {

    @Test
    public void test() {
        LongestSubstringWithKReplacements longestSubstringWithKReplacements = new LongestSubstringWithKReplacements();

        System.out.println(longestSubstringWithKReplacements.findLength("aabccbb", 2)); // should be 5
        System.out.println(longestSubstringWithKReplacements.findLength("abbcb", 1)); // should be 4
        System.out.println(longestSubstringWithKReplacements.findLength("abccde", 1)); // should be 3
    }
}
