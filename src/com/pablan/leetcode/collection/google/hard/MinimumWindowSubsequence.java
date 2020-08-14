package com.pablan.leetcode.collection.google.hard;

public class MinimumWindowSubsequence {

    /**
     * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
     *
     * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
     *
     * Example 1:
     *
     * Input:
     * S = "abcdebdde", T = "bde"
     * Output: "bcde"
     * Explanation:
     * "bcde" is the answer because it occurs before "bdde" which has the same length.
     * "deb" is not a smaller window because the elements of T in the window must occur in order.
     *
     * Pablo's notes: This is not minimum window substring, this is minimum window subsequence. The order here is
     * important, sequence must align one by one.
     *
     * The idea is actually quite simple
     * 1.- Check for feasibility and check for optimization. Notice the following example
     *
     * S = XAYMBAZBDCE
     * T = ABE
     *
     * First, we try to match the next letter
     * X
     * X A -> Here we have a match, now let's try to match B
     * X A Y M B -> Here we have a match again, now let's try to match E
     * X A Y M B A Z B D C E -> Here we have a match again, and we exhausted the pattern. Now
     *                          let's see if there is something better going backwards. Otherwise we will
     *                          end up in the same spot. But now you match backwards because we want to keep the sequence
     * E -> There is match, let's move on and try to find B
     * E C D B -> There is a B, let's move on and find A
     * E C D B Z A -> We match the pattern, cool. Now let's measure the window and try to find something right after A. So
     *                for example: next iteration you start in Z, and try to match against ABE from scratch
     * Z B D C E -> No matches... we couldn't find a better window
     */
    public String minWindow(String S, String T) {
        int j = 0;

        int minWindowLength = Integer.MAX_VALUE;
        int minWindowIndex = -1;
        for(int i = 0; i  < S.length(); i++) {
            if(S.charAt(i) == T.charAt(j)) {
                j++;

                int end = 0;
                if(j == T.length()) {
                    end = i;
                    j--;
                    while(j >= 0) {
                        if(S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    String window = S.substring(i, end + 1); // end is not inclusive
                    if(window.length() < minWindowLength) {
                        minWindowIndex  = i;
                        minWindowLength = window.length();
                    }
                    // Re-initialize next sequence to find if algorithm works
                    j = 0;
                }
            }
        }

        return minWindowIndex == -1 ? "" : S.substring(minWindowIndex, minWindowIndex + minWindowLength);
    }

    /**
     * Original algorithm
     *
     * String ans = "" ;
     *         int j=0;
     *
     *         for(int i=0; i<S.length(); i++) {
     *             if(S.charAt(i) == T.charAt(j)){
     *                 j++;
     *                 if(j >= T.length()){
     *                     int end = i+1;
     *                     j--;
     *                     while(j>=0){
     *                         if(S.charAt(i)==T.charAt(j))
     *                             j--;
     *                         i--;
     *                     }
     *                     i++;
     *                     String temp = S.substring(i, end);
     *                     if(ans.length()==0|| temp.length()<ans.length() )
     *                         ans = temp;
     *                     j = 0;
     *                 }
     *
     *             }
     *         }
     *
     *         return ans;
     */
}
