package com.pablan.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestKSubstring {

    /**
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     *
     * Example 1:
     *
     * Input: s = "eceba", k = 2
     * Output: 3
     * Explanation: T is "ece" which its length is 3.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Set<Character> occurrences = new HashSet<>();

        int windowStart = 0;
        int maxSize = Integer.MIN_VALUE;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if(!occurrences.contains(s.charAt(windowEnd))) {
                occurrences.add(s.charAt(windowEnd));
            }

            while(occurrences.size() > k) {
                Character leftChar = s.charAt(windowStart);
                if(occurrences.contains(leftChar)) {
                    occurrences.remove(leftChar);
                }
                windowStart++;
            }

            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
        }

        return maxSize;
    }
}
