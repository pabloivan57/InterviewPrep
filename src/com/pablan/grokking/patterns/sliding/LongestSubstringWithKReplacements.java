package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKReplacements {

    /**
     * Given a string with lowercase letters only,
     * if you are allowed to replace no more than ‘k’ letters with any letter,
     * find the length of the longest substring having the same letters after replacement.
     *
     * Input: String="aabccbb", k=2
     * Output: 5
     * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
     *
     * Input: String="abbcb", k=1
     * Output: 4
     * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
     *
     * Input: String="abccde", k=1
     * Output: 3
     * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
     */
    public int findLength(String str, int k) {
        Map<Character, Integer> occurrences = new HashMap<>();

        int maxLength = 0;
        int maxOccurrence = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character letter = str.charAt(windowEnd);
            occurrences.put(letter, occurrences.getOrDefault(letter, 0) + 1);
            maxOccurrence = Math.max(maxOccurrence, occurrences.get(letter));

            while((windowEnd - windowStart + 1) - maxOccurrence > k) {
                // We need to shrink the window because we don't have enough characters to swap
                Character leavingLetter = str.charAt(windowStart++);
                occurrences.put(leavingLetter, occurrences.get(leavingLetter) - 1);
                if(occurrences.get(leavingLetter) <= 0) {
                    occurrences.remove(leavingLetter);
                }
            }

            int windowSize = windowEnd - windowStart + 1;
            maxLength = Math.max(windowSize, maxLength);
        }

        return maxLength;
    }
}
