package com.pablan.leetcode.collection.google;

import java.util.Stack;

public class BackspaceStringCompare {

    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     *
     * Example 1:
     *
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     *
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     *
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     *
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     *
     * Note:
     *
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     * Follow up:
     *
     * Can you solve it in O(N) time and O(1) space?
     */
    public boolean backspaceCompare(String s, String t) {
        int endS = s.length() - 1;
        int endT = t.length() - 1;

        int skipS = 0;
        int skipT = 0;
        while(endS >= 0 || endT >= 0) {
            while (endS >= 0) {
                if(s.charAt(endS) == '#') {
                    skipS++;
                    endS--;
                } else if(skipS > 0) {
                    skipS--;
                    endS--;
                } else {
                    break;
                }
            }

            while (endT >= 0) {
                if(s.charAt(endT) == '#') {
                    skipT++;
                    endT--;
                } else if(skipT > 0) {
                    skipT--;
                    endT--;
                } else {
                    break;
                }
            }

            if(s.charAt(endS) != s.charAt(endT)) {
                return false;
            } else if(endS == 0 && endT == 0) {
                return true;
            }
            endS--;
            endT--;
        }

        return false;
    }
}
