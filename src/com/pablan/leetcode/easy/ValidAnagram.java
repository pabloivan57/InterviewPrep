package com.pablan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // This is one way of doing it but is not very optimal, however on interview it will work
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> occurrences = new HashMap<>();

        int letterCount = s.length();
        for(int i = 0; i < letterCount; i++) {
            char character = s.charAt(i);
            occurrences.put(character, occurrences.getOrDefault(character, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if(occurrences.containsKey(character) && occurrences.get(character) != 0) {
                letterCount--;
                occurrences.put(character, occurrences.get(character) - 1);
            }
        }

        return letterCount == 0;
    }

    public boolean isAnagramOptimized(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count : counter) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
