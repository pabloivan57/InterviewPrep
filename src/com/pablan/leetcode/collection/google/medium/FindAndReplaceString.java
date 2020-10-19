package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplaceString {

    /**
     *  o some string S, we will perform some replacement operations that replace groups of
     *  letters with new ones (not necessarily the same size).
     *
     * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.
     * The rule is that if x starts at position i in the original string S, then we will replace that occurrence
     * of x with y.  If not, we do nothing.
     *
     * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff",
     * then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
     *
     * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee",
     * as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does
     * nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
     *
     * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in
     * replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
     *
     * Example 1:
     *
     * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
     * Output: "eeebffff"
     * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
     * "cd" starts at index 2 in S, so it's replaced by "ffff".
     *
     * Example 2:
     *
     * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
     * Output: "eeecd"
     * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
     * "ec" doesn't starts at index 2 in the original S, so we do nothing.
     *
     * Pablo's notes: The trick here is to keep a table of the indexes that are valid replacements
     * and then forget about S but use the table to build a string instead. For example above:
     *
     * abcd ,indexes = [0,2], sources = ["a","cd"]
     * is source at index 0 valid? Yes
     * index 0 goes to target index 0
     * is source at index 2 valid? Yes
     * index 2 got to target index  1
     *
     * 0 -> 0
     * 2 -> 1
     *
     * now create a new string by iterating over S
     * do I have a valid replacement at index 0? Yes
     * result -> add target at index 0
     * result =  eee and jump by the part that was matched in S, in other words source[0] = 1... i is now 1
     * do I have a valid replacement at index 1? No
     * result -> add S at index 1
     * result = eeeb and jump by 1
     * do I have a valid replacement at 2? Yes
     * result -> add target at index 1, this is because table tells us 2 -> 1
     * result = eeebfff and jump by source[1]... i is now 4
     * Finish loop
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> validReplacements = new HashMap<>();
        for(int i = 0; i < indexes.length; i++) {
            if(S.startsWith(sources[i], indexes[i])) {
                validReplacements.put(indexes[i], i);
            }
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        while( i < S.length()) {
            if(validReplacements.containsKey(i)) {
                result.append(targets[validReplacements.get(i)]);
                i += sources[validReplacements.get(i)].length();
            } else {
                result.append(S.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
