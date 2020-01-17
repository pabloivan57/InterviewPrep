package com.pablan.leetcode.medium;

public class LongestPalindromicSubstring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     *
     */
    public String longestPalindrome(String s) {
        return findLongestPalindrome(s, 0, s.length() - 1);
    }

    public String findLongestPalindrome(String s, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return "";
        }

        if(startIndex == endIndex) {
            return String.valueOf(s.charAt(startIndex));
        }

        if(s.charAt(startIndex) == s.charAt(endIndex)) {
            return s.charAt(startIndex) + findLongestPalindrome(s, startIndex + 1, endIndex - 1) + s.charAt(endIndex);
        } else {
            String case1 = findLongestPalindrome(s, startIndex + 1, endIndex);
            String case2 = findLongestPalindrome(s, startIndex, endIndex - 1);

            if(case1.length() > case2.length()) {
                return case1;
            } else {
                return case2;
            }
        }
    }

    public int findLPSLength(String srt) {
        return findLPSRecursive(srt, 0, srt.length() - 1);
    }

    private int findLPSRecursive(String str, int startIndex, int endIndex) {
        // base condition, if we already looked at all letters
        if(startIndex > endIndex) {
            return 0;
        }

        // base condition every letter of length 1 is a palindrome
        if(startIndex == endIndex) {
            return 1;
        }

        char left = str.charAt(startIndex);
        char right = str.charAt(endIndex);

        if(left == right) {
            return 2 + findLPSRecursive(str, startIndex + 1, endIndex - 1);
        } else {
            // case 1 we skip left
            int c1 = findLPSRecursive(str, startIndex + 1, endIndex);
            // case 2 we skip right
            int c2 = findLPSRecursive(str, startIndex, endIndex - 1);
            return Math.max(c1, c2);
        }
    }

    public int findLPSLengthBottomUp(String st) {
        int[][] dp = new int[st.length()][st.length()];

        // Base cases, with just one letter. Palindrome is 1
        for(int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        // Build up table
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }

        return dp[0][st.length() - 1];
    }
}
