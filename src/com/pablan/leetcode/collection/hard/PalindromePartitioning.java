package com.pablan.leetcode.collection.hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     *
     * Pablo's notes: The way to go about this is with backtracking, you try all possibilities
     *
     * aab
     * Let's start picking 1 letter from the left a.
     * By definition a single letter is a palindrome, cool so now let's try splitting the right side
     * [a]  [ab]. If we work with ab let's start splitting with the first letter
     * [a]  [a] [b]. Let's work with b. let's split it... well it's palindrome and we can't split even furter so backtrack.
     *               This is a response btw
     * [a]   [ab] --> We are back at this point. Now let's try all numbers [ab], is it palindrome? no, backtrack
     * [aab] --> Now instead of picking far left a we do [aa] [b]
     * [aa]  [b] -> b cannot be split anymore and it's palinrome
     *                This is another response, backtrack
     * [aab] -> Now let's try [aab], is it palindrome? Nope... well, we are done
     *
     */
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(lists, list, s, 0, s.length() - 1);
        return lists;
    }

    public void backtrack(List<List<String>> lists, List<String> list, String s, int startIndex, int endIndex) {
        // base case
        if(startIndex >= endIndex || isPalindrome(s, startIndex, endIndex)) {
            list.add(s.substring(startIndex, endIndex + 1));
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for(int i = startIndex; i <= endIndex; i++) {
            if(isPalindrome(s, startIndex, i)) {
                list.add(s.substring(startIndex, i + 1));
                backtrack(lists, list, s, i + 1, endIndex);
                list.remove(list.size() - 1);
            }
        }
    }

    public int partitionCuts(String s) {
        return partitionCutsRecursive(s, 0, s.length() - 1);
    }

    private int partitionCutsRecursive(String s, int startIndex, int endIndex) {
        // '=' because 'a' needs 0 cuts
        if(startIndex >= endIndex || isPalindrome(s, startIndex, endIndex)) {
            return 0;
        }

        //try all possibilities (endIndex - startIndex == length of portion - 1)
        int minCuts = endIndex - startIndex;
        for(int i = startIndex; i <= endIndex; i++) {
            if(isPalindrome(s, startIndex, i)) {
                minCuts = Math.min(minCuts, 1 + partitionCutsRecursive(s, startIndex + 1, endIndex));
            }
        }

        return minCuts;
    }

    private boolean isPalindrome(String s, int x, int y) {
        while(x < y) {
            if(s.charAt(x) != s.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }

        return true;
    }
}
