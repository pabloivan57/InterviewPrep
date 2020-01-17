package com.pablan.leetcode.medium;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void test() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
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
