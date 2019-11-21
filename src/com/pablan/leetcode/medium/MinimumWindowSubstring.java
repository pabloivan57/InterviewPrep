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
        if(s.length() == 0) return "";

        Map<Character, Integer> occurrences = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            occurrences.put(key, occurrences.getOrDefault(key, 0) + 1);
        }

        int windowStart = 0;
        int minSize = Integer.MIN_VALUE;
        int minIndex = 0;
        int matched = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character rightChar = s.charAt(windowEnd);
            if(occurrences.containsKey(rightChar)) {
                occurrences.put(rightChar, occurrences.get(rightChar) - 1);
                // Only if I have characters to match we increase, otherwise
                // that means we have repeated characters that are not part of the pattern
                // ex: bba ab --> b : 1, iteration 1 / b = 0, iteration 2 / b = -1 (this is not a match)
                if(occurrences.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while(matched == t.length()) {
                int windowSize = windowEnd - windowStart;
                if(windowSize < minSize) {
                    minSize = windowSize;
                    minIndex = windowStart;
                }

                Character leftChar = s.charAt(windowStart);
                if(occurrences.containsKey(leftChar)) {
                    // Because of above's comment we need to avoid repeated characters
                    if(occurrences.get(leftChar) >= 0) {
                        matched--;
                    }
                    occurrences.put(leftChar, occurrences.get(leftChar) + 1);
                }
            }
        }

        return minSize == Integer.MIN_VALUE ? "" : s.substring(minIndex, minIndex + minSize);
    }
}
