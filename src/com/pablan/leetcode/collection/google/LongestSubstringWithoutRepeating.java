package com.pablan.leetcode.collection.google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     */
    public int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();

        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Set<Character> characterSet = new HashSet<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char current = letters[windowEnd];
            while(characterSet.contains(current)) {
                characterSet.remove(letters[windowStart++]);
            }

            characterSet.add(current);
            int localLength = windowEnd - windowStart + 1;
            maxLength = Math.max(localLength, maxLength);
        }

        return maxLength;
    }
}
