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
     * Pablo's notes: Actually this problem is not terribly complicated but requires a couple use cases that make it complex.
     * Basically it's as follows. You have 3 scenarios
     * 1) characters match. advance both pointers
     * 2) character match ?. Advance both pointers
     * 3) character match *. Here is where things get tricky
     *
     *       imagine adceb
     *               ^
     *               *a*b
     *               ^
     *  In this case * matches nothing as a will match current pointer in s1. However, there is another example
     *
     *       imagine adcaib
     *               ^
     *               *a?b
     *               ^
     *   In the case above if * matches nothing, the operations will results in false. BUT it should be true
     *   that's because we can match * with the other 'a' at positiion 3
     *   So from a computer perspective when you see a '*' You ask? Ok this could match current s1 but it could be later.
     *   With that in mind you "store" the pattern index that you will go back to in the case we have to match later
     *   That's when star_idx is used
     *
     *   Now, for the lastAttemptedMatch It's useful to look at the following example:
     *
     *   abcabczzzde
     *   *abc???de*
     *
     *   Here if we match against nothing we will match everything and be block when we reach zzz in the pattern. So we say
     *   maybe it will match somewhere else? so instead of matching with the first character in s == 'a'. We blindly try
     *   the next character. Does b match a? Nope... next character
     *   Does c match a? Nope... next character
     *   Does a match a? Yes, cool let's move on from there.
     *
     *   This is why a lastMatchAttempted variable is needed. To attempt to match * with as many characters until we
     *   find pattern again
     *
     *   So going back to
     *   abcabczzzde
     *   *abc???de*
     *
     *   We check *, we save start_index = 0. We move pattern to 1 == a. LastAttemptMatched = 0, because yeah... we are going to try s_idx = 0
     *   We check s_idx = 0 at matches p_idx = 1. Go on
     *   We check s_idx = 1 and matche p_idx = 1. Go on
     *   .
     *   .
     *   .
     *   We check s_idx = 3 (a) and matches p_idx = 4 (?). Go on
     *   .
     *   .
     *   .
     *   We reached s_idx = 6 (z) and DOESN'T match p_idx = 7 (d). What do we do? Well... we
     *   matched * with index 0... but what if we could find another idx to match with *. So this is
     *   where we use start_idx and lastAttemptMatched = 0  to restart the process. BUt we move to the next lastAttemptMatched
     *   s_idx = lastAttemptMatched + 1
     *   lastAttemptMatched++
     *   p_idx = start_idx + 1
     *   we are at s_idx = 1 and p_idx = 1. Do they match? Nope, we try to match again from the next number
     *   s_idx = lastAttempMatched + 1
     *   we are at s_idx = 2 and p_idx = 1. Do they match? Nope, we try to match again from the next number
     *   .
     *   .
     *   .
     *   We are finally at s_idx = 3 and p_idx = 1. Match? Yes, cool go on
     *   .
     *   .
     *   .
     *   We reach the end of the string and pattern has 1 * => The operation is true
     *
     *
     */
    boolean isMatch(String str, String pattern) {
        int sIdx = 0;
        int pIdx = 0;
        int startIdx = -1;
        int lastAttemptToMatch = 0;

        while(sIdx < str.length()) {
            // Case 1 pattern matches
            if(pIdx < pattern.length() && (pattern.charAt(pIdx) == '?' || str.charAt(sIdx) == pattern.charAt(pIdx))) {
                // We advance string and pattern
                sIdx++;
                pIdx++;
            } else if(pIdx < pattern.length() && pattern.charAt(pIdx) == '*') {
                // star case, match anything
                startIdx = pIdx;
                lastAttemptToMatch = sIdx;
                pIdx++;
            } else if(startIdx == -1) {
                // There has been no star and no match, return false
                return false;
            } else {
                pIdx = startIdx + 1;
                lastAttemptToMatch++;
                sIdx = lastAttemptToMatch;
            }
        }

        // Check if remaining pattern elements are *
        // This is for use case "" "*****" or when you have a * at the end of the patter (* matches empty)
        while (pIdx < pattern.length() && pattern.charAt(pIdx) == '*')
            pIdx++;

        return pIdx == pattern.length();
    }
}
