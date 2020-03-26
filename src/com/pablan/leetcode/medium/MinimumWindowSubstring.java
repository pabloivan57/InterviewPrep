package com.pablan.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

     Example:

     Input: S = "ADOBECODEBANC", T = "ABC"
     Output: "BANC"
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            occurrences.put(t.charAt(i), occurrences.getOrDefault(t.charAt(i), 0) + 1);
        }

        int windowStart = 0;
        int matches = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minWindowIndex = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character currentLetter = s.charAt(windowEnd);
            if(occurrences.containsKey(currentLetter)) {
                if(occurrences.get(currentLetter) > 0) {
                    matches++;
                }
                occurrences.put(currentLetter, occurrences.get(currentLetter) - 1);
            }

            while(matches == t.length()) {
                int windowSize = windowEnd - windowStart + 1;
                if(windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    minWindowIndex = windowStart;
                }

                Character leavingLetter = s.charAt(windowStart++);
                if(occurrences.containsKey(leavingLetter)) {
                    occurrences.put(leavingLetter, occurrences.get(leavingLetter) + 1);
                    if(occurrences.get(leavingLetter) > 0) {
                        matches--;
                    }
                }
            }
        }

        return s.substring(minWindowIndex, minWindowIndex + minWindowSize);
    }
}
