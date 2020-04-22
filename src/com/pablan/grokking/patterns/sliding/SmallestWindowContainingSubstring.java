package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

    /**
     * Given a string and a pattern, find the smallest substring in the given string
     * which has all the characters of the given pattern.
     *
     * Input: String="aabdec", Pattern="abc"
     * Output: "abdec"
     * Explanation: The smallest substring having all characters of the pattern is "abdec
     *
     * Input: String="abdabca", Pattern="abc"
     * Output: "abc"
     * Explanation: The smallest substring having all characters of the pattern is "abc".
     *
     * Input: String="adcad", Pattern="abc"
     * Output: ""
     * Explanation: No substring in the given string has all characters of the pattern.
     */
    public String findSubstring(String str, String pattern) {
        // load pattern
        Map<Character, Integer> occurrences = new HashMap<>();
        for(char character : pattern.toCharArray()) {
            occurrences.put(character, occurrences.getOrDefault(character, 0) + 1);
        }

        int matches = 0;
        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minWindowIndex = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(occurrences.containsKey(rightChar)) {
                occurrences.put(rightChar, occurrences.get(rightChar) - 1);
                if(occurrences.get(rightChar) >= 0) {
                    // There are still letters to match
                    matches++;
                }
            }

            // while I have all letters try to shrink window
            while(matches == pattern.length()) {
                int localWindowSize = windowEnd - windowStart + 1;
                int localWindowIndex = windowStart;

                // If I found a smaller window, store it
                if(minWindowSize > localWindowIndex) {
                    minWindowSize = localWindowSize;
                    minWindowIndex = localWindowIndex;
                }

                char leftChar = str.charAt(windowStart++);
                if(occurrences.containsKey(leftChar)) {
                    occurrences.put(leftChar, occurrences.get(leftChar) + 1);
                    if(occurrences.get(leftChar) > 0) {
                        matches--;
                    }
                }
            }
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : str.substring(minWindowIndex, minWindowIndex + minWindowSize);
    }
}
