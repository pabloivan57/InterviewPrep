package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     *
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public List<List<String>> wordBreakRecursive(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        List<String> sequence = new ArrayList<>();
        findWord(s, 0, s.length(), sequence, wordDict, result);
        return result;
    }

    private void findWord(String s, int start, int end, List<String> sequence,
                                  List<String> wordDict,
                                  List<List<String>> result) {
        if(start >= end) {
            result.add(new ArrayList<>(sequence));
            return;
        }

        for(int i = start; i <= end; i++) {
            String prefix = s.substring(start, i);
            if(wordDict.contains(prefix)) {
                sequence.add(prefix);
                findWord(s, i, end, sequence, wordDict, result);
                //backtrack
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
