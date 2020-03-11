package com.pablan.leetcode.medium;

import org.junit.Test;

public class LengthOfLongestKSubstringTest {

    @Test
    public void test() {
        LengthOfLongestKSubstring lengthOfLongestKSubstring = new LengthOfLongestKSubstring();
        System.out.println(lengthOfLongestKSubstring.lengthOfLongestSubstringKDistinct("eceba", 2)); // should be 3
    }
}
