package com.pablan.grokking.patterns.sliding;

import java.util.HashSet;

public class NoRepeatSubstring {

    /**
     * Given a string, find the length of the longest substring which has no repeating characters.
     *
     * Input: String="aabccbb"
     * Output: 3
     * Explanation: The longest substring without any repeating characters is "abc".
     *
     * Input: String="abbbb"
     * Output: 2
     * Explanation: The longest substring without any repeating characters is "ab".
     *
     * Input: String="abccde"
     * Output: 3
     * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
     */
    public int findLength(String str) {
        HashSet<Character> different = new HashSet<>();
        int maxLength = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character letter = str.charAt(windowEnd);
            while(different.contains(letter)) {
                Character leavingLetter = str.charAt(windowStart++);
                different.remove(leavingLetter);
            }

            different.add(letter);
            int length = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
