package com.pablan.leetcode.medium;

public class LongestPalindromicSubstring {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     *  NOTE: THIS IS SUBSTRING!, THIS MEANS CHARACTERS HAVE TO BE SEQUENTIAL
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * Example 3:
     *
     * Input: s = "a"
     * Output: "a"
     * Example 4:
     *
     * Input: s = "ac"
     * Output: "a"
     *
     * Pablo's notes: The simple way of going about this exercise without DP fanciness and equally performant
     * is as follows. Simply start extending the palindrome from each position until you can't. Keep track of them max
     *
     * Now, the trick here is that there are two types of string you can encounter. Even and odd
     * odd palindomes will start with both characters equal in the center. Whereas even palindromes will end in one
     *
     * for example:
     * type 1) abba
     * type 2) aba
     *
     *  This is why the algorithm starts from i expanding and also from i, i+1
     */
    int maxPalindromeLength = 0;
    int maxPalindromeStart = 0;

    public String longestPalindrome(String s) {
        maxPalindromeLength = 0;
        maxPalindromeStart = 0;

        for(int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(maxPalindromeStart, maxPalindromeStart + maxPalindromeLength);
    }

    private void expand(String s, int start, int end) {

        int palindromeLength = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        palindromeLength = end - start - 1  ;
        if(maxPalindromeLength < palindromeLength) {
            maxPalindromeLength = palindromeLength;
            maxPalindromeStart = start + 1;
        }
    }
}
