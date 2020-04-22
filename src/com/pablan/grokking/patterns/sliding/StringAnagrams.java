package com.pablan.grokking.patterns.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

    /**
     * Given a string and a pattern, find all anagrams of the pattern in the given string.
     *
     * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
     *
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
     *
     * Input: String="ppqp", Pattern="pq"
     * Output: [1, 2]
     * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
     *
     * Input: String="abbcabc", Pattern="abc"
     * Output: [2, 3, 4]
     * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
     */
    public List<Integer> findStringAnagrams(String str, String pattern) {
        Map<Character, Integer> occurrences = new HashMap<>();
        char[] word = pattern.toCharArray();
        for(char letter : word) {
            occurrences.put(letter, occurrences.getOrDefault(letter, 0) + 1);
        }

        List<Integer> indexes = new ArrayList<>();
        int windowStart = 0;
        int matches = 0; // we will match how many type of letters we have matched so far
                         // when we have no more letters of that type left
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(occurrences.containsKey(rightChar)) {
                occurrences.put(rightChar, occurrences.getOrDefault(rightChar, 0) - 1);
                if(occurrences.get(rightChar) == 0) { // this means we have matches all letters of type 'X'. I.E: All a's
                    matches++;
                }
            }

            if(matches == occurrences.size()) {
                // This means we have matches all letters in the pattern
                indexes.add(windowStart);
            }

            //We shrink window on every letter,but only after our window is big enough as the pattern size
            if(windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if(occurrences.containsKey(leftChar)) {
                    if(occurrences.get(leftChar) == 0) {
                        matches--;
                    }
                    occurrences.put(leftChar, occurrences.get(leftChar) + 1);
                }
            }
        }

        return indexes;
    }
}
