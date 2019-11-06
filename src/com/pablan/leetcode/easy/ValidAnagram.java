package com.pablan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /**
     *
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < 26; i++) {
            if(counter[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
