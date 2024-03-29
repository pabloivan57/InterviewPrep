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
     * Pablo's notes: So, this is DP but recursive is common logic. Here's how you go about it
     * So, when they are equal then you're cool, and we are comparing by having two pointers
     * i in s1, and j in s2. Just skip to the next index
     * When they are different, ok now what can we do?
     * 1.- We replace one of them to match
     * 2.- We remove letter i in s1, hoping that i + 1 == j in s2
     * 3.- We remove letter j in s2, hoping that j + 1 == i in s1
     *
     * we have to consider all three scenarios. And when do we end?
     * Well if both i and j are at the end of both s1 and s2 and they are equal... we finished
     * Also, if we have i out of boundaries of s1 that is invalid
     * Also, if we have j out of boundaries of s2 that is invalid
     *
     */
    public int findMinOperations(String s1, String s2) {
        //return findMinOperations(0, s1, 0, s2, 0);
        return findMinOperationsDp(s1, s2);
    }

    private int findMinOperations(int index1, String s1, int index2, String s2, int operations) {
        // if one of the strings is out of boundaries prune
        if(index1 >= s1.length() || index2 >= s2.length()) {
            return Integer.MAX_VALUE;
        }

        // base case, if we are at the end and both are equal
        boolean equal = s1.charAt(index1) == s2.charAt(index2);
        if(index1 == s1.length() - 1 && index2 == s2.length() - 1 && equal) {
            return operations;
        }

        // equal
        if(equal) {
            return findMinOperations(index1 + 1, s1, index2 + 1, s2, operations);
        }

        // case1 replace
        int case1 = findMinOperations(index1 + 1, s1, index2 + 1, s2, operations + 1);
        // case2 delete s1
        int case2 = findMinOperations(index1 + 1, s1, index2, s2, operations + 1);
        // case3 delete s2
        int case3 = findMinOperations(index1, s1, index2 + 1, s2, operations + 1);

        return Math.min(case1, Math.min(case2, case3));
    }

    /**
     *  The DP approach actually makes sense... however there is a tricky part, as you know
     *  DP usually takes a base case out of it's ass. For example
     *  bat and but.. we know it starts at index 0 with b == b. But is there something before that?
     *  yes... the empty string "" "" which we can say it's index -1 "" == "".
     *  Now, because you can't work with arrays and negative indexes you do this
     *  ["", b, a, t] and ["", b, u, t] and say that index 0 "" == ""
     *  and index 1 now b == b... that's why later you will see a weird s1.charAt(i - 1) check
     *  That is because we "transposed" all the letters one element to the right in the dp matrix
     *
     *  Anyways, building the matrix makes sense... simply put both elements in the matrix and
     *  start counting how many changes we need to get there
     *      "" b  u  t
     *  ""  0  1  2  3  --> 1 2 3 because b to make it "" you need 1 deletion, bu to make "" you need 2 deletions, etc
     *  b   1  0        --> This means If b == b, cool now just check i - 1 and j - 1 to see if they are equal. If not then total operations will be i - 1 and j - 1 which you already calcualted
     *  a   2           --> Here u != a, so now you ask. Which one is better? replacing and checking i - 1 and j - 1 or deleting i at s1 or deleting j at s2
     *  t   3
     *
     */
    private int findMinOperationsDp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // base cases compare s1 to ""
        for(int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        // base cases compare s2 to ""
        for(int i = 0 ; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
