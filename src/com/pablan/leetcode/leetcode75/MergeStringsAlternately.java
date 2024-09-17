package com.pablan.leetcode.leetcode75;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 * append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */
public class MergeStringsAlternately {

    /**
     * Pablo's comments: Intuition tells you to do a two pointer, sort of the
     * final portion of merge sort. However, you can actually do in one pass
     * simply run the pointer to the max size of both word and then check
     * if pointer is within bounds for left word, take letter. Now, if pointer
     * is within bounds of right word. Take it and so on... you can take letters
     * in the same loop
     *
     */
    public String mergeAlternately(String word1, String word2) {
        int p = 0;

        StringBuilder result = new StringBuilder();
        while(p < word1.length() || p < word2.length()) {
            if(p < word1.length()) {
                result.append(word1.charAt(p));
            }

            if(p < word2.length()) {
                result.append(word2.charAt(p));
            }

            p++;
        }

        return result.toString();
    }

    /**
     * Pablo's original code
     * public String mergeAlternately(String word1, String word2) {
     *         int p1 = 0;
     *         int p2 = 0;
     *
     *         StringBuilder result = new StringBuilder();
     *         boolean pickLeft = true;
     *         while(p1 < word1.length() && p2 < word2.length()) {
     *             if(pickLeft) {
     *                 result.append(word1.charAt(p1++));
     *             } else {
     *                 result.append(word2.charAt(p2++));
     *             }
     *             pickLeft = !pickLeft;
     *         }
     *
     *         while(p1 < word1.length()) {
     *             result.append(word1.charAt(p1++));
     *         }
     *
     *         while(p2 < word2.length()) {
     *             result.append(word2.charAt(p2++));
     *         }
     *
     *         return result.toString();
     *     }
     */
}
