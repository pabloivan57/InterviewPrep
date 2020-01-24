package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingTest {

    @Test
    public void test() {
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("pwwkew"));

    }
}
