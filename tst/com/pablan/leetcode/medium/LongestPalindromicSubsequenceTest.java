package com.pablan.leetcode.medium;

import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void test() {
        LongestPalindromicSubsequence longestPalindromicSubstring = new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubstring.findLPSLength("abdbca"));
        System.out.println(longestPalindromicSubstring.findLPSLength("cddpd"));
        System.out.println(longestPalindromicSubstring.findLPSLength("pqr"));

        System.out.println(longestPalindromicSubstring.longestPalindrome("abdbca"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cddpd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("pqr"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }
}
