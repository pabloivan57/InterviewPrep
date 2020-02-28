package com.pablan.leetcode.collection.hard;

public class WildcardMatching {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
     *
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     * Example 3:
     *
     * Input:
     * s = "cb"
     * p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     * Example 4:
     *
     * Input:
     * s = "adceb"
     * p = "*a*b"
     * Output: true
     * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
     * Example 5:
     *
     * Input:
     * s = "acdcb"
     * p = "a*c?b"
     * Output: false
     *
     * Here is the algorithm.
     *
     * Let's use two pointers here: s_idx to iterate over the string, and p_idx to iterate over the pattern. While s_idx < s_len:
     *
     * If there are still characters in the pattern p_idx < p_len and the characters under the pointers
     * match p[p_idx] == s[s_idx] or p[p_idx] == '?', then move forward by increasing both pointers.
     *
     * Else if there are still characters in the pattern p_idx < p_len, and p[p_idx] == '*',
     * then first check "match zero characters" situation, i.e. increase only pattern pointer p_idx++.
     * Write down for a possible backtrack the star position in star_idx variable, and the current string pointer in s_tmp_idx variable.
     *
     * Else if there is "no match" situation: the pattern is used up p_idx < p_len or the characters under the pointers doesn't match.
     *
     * If there was no stars in the pattern, i.e. no star_idx, return False.
     *
     * If there was a star, then backtrack: set pattern pointer just after the last star p_idx = star_idx + 1, and string pointer
     * s_idx = s_tmp_idx + 1, i.e. assume that this time the star matches one more character.
     * Save the current string pointer for the possible backtrack s_tmp_idx = s_idx.
     *
     * Return True if all remaining characters in the pattern are stars.
     *
     * acdcb
     * a*c?b
     */
    boolean isMatch(String str, String pattern) {
        int sIdx = 0;
        int pIdx = 0;
        int startIdx = -1;

        while(sIdx < str.length()) {
            // Case 1 pattern matches
            if(str.charAt(sIdx) == '?' || str.charAt(sIdx) == pattern.charAt(pIdx)) {
                // We advance string and pattern
                sIdx++;
                pIdx++;
            } else if(pattern.charAt(pIdx) == '*') {
                // star case, match anything
                startIdx = pIdx;
                pIdx++;
            } else if(startIdx == -1) {
                // There has been no star and no match, return false
                return false;
            } else {
                pIdx = startIdx + 1;
                sIdx++;
            }
        }

        return pIdx == pattern.length();
    }
}
