package com.pablan.leetcode.medium;

public class LongestPalindromicSubsequence {

    /**
     * Given a string s, find the longest palindromic subsequence in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "abdbca"
     * Output: 5
     * Explanation: LPS is "abdba".
     *
     * Input: = "cddpd"
     * Output: 3
     * Explanation: LPS is "ddd".
     *
     * Input: = "pqr"
     * Output: 1
     * Explanation: LPS could be "p", "q" or "r".
     *
     * Pablo's notes: To understand the DP approach, here is what we need to do. Basically we will have a 2-dimensional
     * array that represents the following
     * i = startIndex
     * j = endIndex
     * OR "I HAVE A STRING THAT START A POSITION ROW AND ENDS AT POSITION COLUMN"
     *
     * For example:
     *                      end
     *                0  1  2  3  4
     *
     *          0     1
     *          1        1               -->   c d d p d
     * start    2           1
     *          3             1
     *          4                1
     *
     *
     *      The diagonals means... given a string that starts at i and ends at i. That is the character itself
     *      For example: string that starts at index 1 and ends at index 1 of c d d p d? Is 'd' Which is a palindrome
     *
     *      Now how about a string that starts at 3 and ends at 4? c d d p d == pd. Ok so we proceed as a normal
     *      palindrome
     *      p d
     *      ^ ^  --> p == d Nope, then the max palindrome will be the max of removing end or removing start. In other
     *      words if we remove start... then a max palindrome of 'd' is the character itself or 1. If we remove end
     *      then it's the character 'p' or 1 as well. Now let's do a more elaborate example
     *
     *      start = 2 end 4 --> c d d p d  =? 'dpd'
     *                             |_____|
     *
     *      d = d? yes, cool so 2 + the substring in between or p. now in the table which point represents a string
     *      that starts in 'p' and ends in 'p'? Well that is position 3,3 OR start + 1, end - 1
     *
     *      Now let's look at the other example
     *      start 1 end 3 -->  c d d p d   =? 'ddp'
     *                          |_____|
     *
     *      d != p, ok so let's try removing either ends. Our two options are
     *      start 2 end 3 == dp    ==> this means start + 1, end
     *      OR
     *      start 1 end 2  = dd    ==> this means start, end - 1
     *
     *
     *      Graphically this looks like
     *                     end
     *                0  1  2     3  4
     *
     *          0     1
     *          1        * ($) <- *   -->   d != p so let's try start 2 end 3
     *                   |
     *                   v
     * start    2       ($)  *
     *          3             1
     *          4                   1
     *
     *       That shift will explain why we only move 1 start or end in the algorithm. Is so
     *       we align the start and end appropriately in the matrix
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
