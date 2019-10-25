package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    //Input: String="araaci", K=2
    //Output: 4
    //Explanation: The longest substring with no more than '2' distinct characters is "araa"
    public int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            return 0;
        }

        Map<Character, Integer> occurrences = new HashMap<>();
        int windowStart = 0;
        int maxRange = Integer.MIN_VALUE;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character rightChar = str.charAt(windowEnd);
            occurrences.put(rightChar, occurrences.getOrDefault(rightChar, 0) + 1);

            // while we have more than 2 elements
            while (occurrences.size() > k) {
                // remove character that is leaving window 1 count
                Character windowStartChar = str.charAt(windowStart);
                occurrences.put(windowStartChar, occurrences.get(windowStartChar) - 1);
                if(occurrences.get(windowStartChar) == 0) {
                    // Remove entry from map
                    occurrences.remove(windowStartChar);
                }

                //slide the window
                windowStart++;
            }

            // we found a window with <= k distinct characters, but
            // the constraint says no more than 2, so we don't take into account the one that overflood the
            // ocurrences count
            maxRange = Math.max(maxRange, windowEnd - windowStart + 1);
        }

        return maxRange;
    }
}
