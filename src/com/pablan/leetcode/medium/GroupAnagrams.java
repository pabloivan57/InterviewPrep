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
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>();

        int[] count = new int[26];
        for(String s : strs) {
            Arrays.fill(count,  0);

            for(char character : s.toCharArray()) {
                count[character - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count.length; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();

            if(!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
