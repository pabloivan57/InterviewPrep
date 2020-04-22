package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

    /**
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     *
     * Permutation is defined as the re-arranging of the characters of the string.
     * For example, “abc” has the following six permutations:
     *
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * If a string has ‘n’ distinct characters it will have
     * n
     * !
     * n! permutations.
     *
     * Input: String="oidbcaf", Pattern="abc"
     * Output: true
     * Explanation: The string contains "bca" which is a permutation of the given pattern.
     *
     * Input: String="odicf", Pattern="dc"
     * Output: false
     * Explanation: No permutation of the pattern is present in the given string as a substring.
     *
     * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
     * Output: true
     * Explanation: Both the string and the pattern are a permutation of each other.
     *
     * Input: String="aaacb", Pattern="abc"
     * Output: true
     * Explanation: The string contains "acb" which is a permutation of the given pattern.
     */
    public boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> occurrences = new HashMap<>();
        int matchCount = 0;
        int windowStart = 0;

        char[] letters = pattern.toCharArray();
        for(char letter : letters) {
            occurrences.put(letter, occurrences.getOrDefault(letter, 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char letter = str.charAt(windowEnd);
            if(occurrences.containsKey(letter) && occurrences.get(letter) > 0) {
                // Still have pattern letters to match
                matchCount++;
                occurrences.put(letter, occurrences.get(letter) - 1);
            } else {
                // Couldn't find match we have to shorten the window
                char leavingLetter = str.charAt(windowStart++);
                if(occurrences.containsKey(leavingLetter)) {
                    occurrences.put(leavingLetter, occurrences.get(leavingLetter) + 1);
                    matchCount--;
                }
            }

            if(matchCount == pattern.length()) {
                return true;
            }
        }

        return false;
    }
}
