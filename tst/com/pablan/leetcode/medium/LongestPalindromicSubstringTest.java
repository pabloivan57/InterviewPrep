package com.pablan.leetcode.medium;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void test() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad")); // should be "bab" or "aba"
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd")); // should be "bb"
        System.out.println(longestPalindromicSubstring.longestPalindrome("a")); // should be "a"
        System.out.println(longestPalindromicSubstring.longestPalindrome("ac")); // should be "a"
    }
}
