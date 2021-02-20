package com.pablan.leetcode.collection.google.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    /**
     *  A message containing letters from A-Z can be encoded into numbers using the following mapping:
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * To decode an encoded message, all the digits must be grouped then mapped back into letters
     * using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
     *
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     *
     * Pablo's notes: This problem is tricky. Basically you have to analyze the input you're given one at a time
     *
     * 11106
     *
     * * If number is 1 or 2, and next number is between 0 - 6 [alphabet limit], you have two options
     *    1) you decode a single number and continue, index + 1
     *    2) you decode two characters and continue, index + 2
     *
     * * If a number is everything else except 0 then
     *    1) continue, index + 1
     *
     * * If a number is 0 and is not the last one
     *    1) then this is invalid, return no ways (0)
     *
     *    so the algorithm goes like this
     *
     *    case1 = numWays(index + 1)
     *    case2 = numWays(index + 2) if index is '1' or '2' and index + 1 is < '7'
     *
     *    when you reach the end stop. Or if you find a 0 that is not at the very end, stop as well
     *
     *
     */
    public int numDecodings(String s) {
        return numDecodings(0, s);
    }

    public int numDecodings(int index, String s) {
        // Only way to be 0 at this point is valid because it will be right next to a 1 or 2
        if(index == s.length()) {
            return 1;
        }

        if(index > s.length() || s.charAt(index) == '0') {
            // this case is not valid because a 0 cannot be in between
            // and you might be thinking... well how about 10. We will make sure this case is not ignored
            // because we will be jumping 2 indexes in case1
            return 0;
        }

        // at this point this is a valid encoding, we take just 1 letter and continue
        int case1 = numDecodings(index + 1, s);

        // Now, how about the cases where we have 2 numbers
        int case2 = 0;
        if(index < s.length() - 1 && (s.charAt(index) == '1' || s.charAt(index) == '2') && s.charAt(index + 1) < '7') {
            case2 = numDecodings(index + 2, s);
        }

        return case1 + case2;
    }

    private int numDecodingsBottomUp(String s) {
        int dp[] = new int[s.length() + 1];

        dp[s.length()] = 1; // This is just a trick, you need a way of initializing
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != 0) {
                int case1 = dp[i + 1];
                // If I can go to the next character
                int case2 = 0;
                if(i < s.length() - 1 && s.charAt(i + 1) < '7') {
                    case2 = dp[i + 2];
                }

                dp[i] = case1 + case2;
            }
        }

        return dp[0];
    }
}
