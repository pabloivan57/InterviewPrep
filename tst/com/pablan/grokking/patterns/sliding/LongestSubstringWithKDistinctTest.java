package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class LongestSubstringWithKDistinctTest {

    @Test
    public void test() {
        System.out.println("Length of the longest substring: " + new LongestSubstringKDistinct().findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + new LongestSubstringKDistinct().findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + new LongestSubstringKDistinct().findLength("cbbebi", 3));
    }
}
