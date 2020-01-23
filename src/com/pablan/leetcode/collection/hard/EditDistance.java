package com.pablan.leetcode.collection.hard;


public class EditDistance {

    /**
     * Given strings s1 and s2, we need to transform s1 into s2 by deleting, inserting, or replacing characters.
     * Write a function to calculate the count of the minimum number of edit operations.
     *
     * Example 1:
     *
     * Input: s1 = "bat"
     *        s2 = "but"
     * Output: 1
     * Explanation: We just need to replace 'a' with 'u' to transform s1 to s2.
     * Example 2:
     *
     * Input: s1 = "abdca"
     *        s2 = "cbda"
     * Output: 2
     * Explanation: We can replace first 'a' with 'c' and delete second 'c'.
     * Example 3:
     *
     * Input: s1 = "passpot"
     *        s2 = "ppsspqrt"
     * Output: 3
     * Explanation: Replace 'a' with 'p', 'o' with 'q', and insert 'r'.
     *
     */
    public int findMinOperations(String s1, String s2) {
        return findMinOperations(s1, s2, 0, 0, 0);
    }

    private int findMinOperations(String s1, String s2, int idx1, int idx2, int operations) {
        // If we reached the end of 1 of the strings
        if(idx1 >= s1.length() || idx2 >= s2.length()) {
            return Integer.MAX_VALUE;
        }

        // Base case if we are at the end and both match
        boolean equal = s1.charAt(idx1) == s2.charAt(idx2);
        if(idx1 == s1.length() - 1 && idx2 == s2.length() - 1 && equal) {
            return operations;
        }

        // If both are equal
        if(equal) {
            return findMinOperations(s1, s2, idx1 + 1, idx2 + 1, operations);
        }

        // else
        // case1: delete s1
        // case2: delete s2
        // case3: replace
        int case1 = findMinOperations(s1, s2, idx1 + 1, idx2, operations + 1);
        int case2 = findMinOperations(s1, s2, idx1, idx2 + 1, operations + 1);
        int case3 = findMinOperations(s1, s2, idx1 + 1, idx2 +1, operations + 1);

        return Math.min(Math.min(case1, case2), case3);
    }

    public int findMinOperationsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Base case1 amount of operations to match s1 with ""
        for(int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        // Base case2 amount of operations to match "" with s2
        for(int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
