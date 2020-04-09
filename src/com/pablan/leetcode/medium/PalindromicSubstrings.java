package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    /**
     * Given a string, your task is to count how many palindromic substrings in this string.
     *
     * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
     *
     * Example 1:
     *
     * Input: "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     *
     * Input: "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     *
     * Pablo's notes: - For naive approach (at least something, start expanding at each center and you will find
     * all palindromes, but in O(n^2))
     * For linear time, you will have to use Manacher's algorithm
     *
     */
    public int countSubstrings(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> totalDecomp = new ArrayList<>();
        decomponse(0, s.length() - 1, s, current, totalDecomp);
        return totalDecomp.size() > 0 ? totalDecomp.get(0).size() : 0;
    }

    private void decomponse(int start, int end, String s, List<String> current, List<List<String>> totalDecomp) {
        if(start > end) {
            totalDecomp.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= end; i++) {
            String option = s.substring(start, i + 1);
            if(isPalindrome(option)) {
                current.add(option);
                decomponse(i + 1, end, s, current, totalDecomp);
                // backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
