package com.pablan.leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    /**
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * Pablo's notes: The idea is to make each word a "value" that we can group in a key
     * using the letters, for example ate could be "#1#0#0#0#1#0#0" 1a's, 0 b's, 0 c's, etc
     * Now... it doesn't have to be # (just numbers is fine 10011)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] counter = new int[26];

        HashMap<String, List<String>> groups = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            Arrays.fill(counter, 0);
            String word = strs[i];
            char[] letters = word.toCharArray();

            for(int j = 0; j < letters.length; j++) {
                counter[letters[j] - 'a']++;
            }

            StringJoiner keyJoiner = new StringJoiner("#");
            for(int j = 0; j < counter.length; j++) {
                keyJoiner.add(Integer.toString(counter[j]));
            }

            String key = keyJoiner.toString();
            if(groups.get(key) == null) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}
