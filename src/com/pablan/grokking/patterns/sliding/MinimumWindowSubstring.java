package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    //Input: String="aabdec", Pattern="abc"
    //Output: "abdec"
    //Explanation: The smallest substring having all characters of the pattern is "abdec"
    public String findSubstring(String str, String pattern){
        char[] letters = str.toCharArray();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // load the pattern count
        for(int i = 0; i < pattern.length(); i++) {
            charFrequencyMap.put(pattern.charAt(i), charFrequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int windowStart = 0;
        int matches = 0;
        int minRange = Integer.MAX_VALUE;
        int minRangeStart = 0;
        for(int windowEnd = 0; windowEnd < letters.length; windowEnd++) {
            if(charFrequencyMap.containsKey(letters[windowEnd])) {
                charFrequencyMap.put(letters[windowEnd], charFrequencyMap.get(letters[windowEnd]) - 1);
                if(charFrequencyMap.get(letters[windowEnd]) >= 0) {
                    matches++;
                }
            }

            while(matches == pattern.length()) {
                if( windowEnd - windowStart < minRange) {
                    minRange = windowEnd - windowStart + 1;
                    minRangeStart  = windowStart;
                }

                if(charFrequencyMap.containsKey(letters[windowStart])) {
                    if(charFrequencyMap.get(letters[windowStart]) == 0)  {
                        matches--;
                    }
                    charFrequencyMap.put(letters[windowStart], charFrequencyMap.get(letters[windowStart]) + 1);
                }
                windowStart++;
            }
        }

        return minRange > str.length() ?  "" : str.substring(minRangeStart, minRangeStart + minRange);
    }
}
