package com.pablan.leetcode.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occurrences = new HashSet<>();
        int windowStart = 0;
        int maxSize = 0;

        for(int windowEnd = 0; windowEnd < s.length();) {
            Character character = s.charAt(windowEnd);
            if(!occurrences.contains(character)) {
                occurrences.add(character);
                windowEnd++;
                maxSize = Math.max(maxSize, windowEnd - windowStart);
            } else {
                while(occurrences.contains(character)) {
                    Character leavingCharacter = s.charAt(windowStart);
                    occurrences.remove(leavingCharacter);
                    windowStart++;
                }
            }
        }

        return maxSize;
    }
}
