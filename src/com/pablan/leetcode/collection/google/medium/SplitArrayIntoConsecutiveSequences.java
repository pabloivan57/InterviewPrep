package com.pablan.leetcode.collection.google.medium;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSequences {

    /**
     * Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more
     * subsequences such that each subsequence consists of consecutive integers and has length at least 3.
     *
     * Example 1:
     *
     * Input: [1,2,3,3,4,5]
     * Output: True
     * Explanation:
     * You can split them into two consecutive subsequences :
     * 1, 2, 3
     * 3, 4, 5
     *
     * Input: [1,2,3,3,4,4,5,5]
     * Output: True
     * Explanation:
     * You can split them into two consecutive subsequences :
     * 1, 2, 3, 4, 5
     * 3, 4, 5
     *
     * Input: [1,2,3,4,4,5]
     * Output: False
     *
     * Pablo's notes: This explanation helps to understand what the algorithm does,
     * notice this is a different example
     *
     * "Took me a while to understand "appendfreq"
     * Here is how I see "appendfreq"
     *
     * eg: [1,2,3,4, 5]
     * // i =1
     * we fall in 3 case "start of a new subsequence"
     * we make 2, 3 freq 0
     * and put <4, 1> in appendfreq, this mean I have 1 subsequence can continue from 4
     *
     * //i =2, 3
     * we continue
     *
     * //i = 4
     * we fall in 2 case since <4, 1> is in appendfreq
     * now this subsequence should end in 5
     * so we decreace <4, 1> to <4, 0> since we no longer have subsequence can continue from 4
     * and we put <5, 1> in appendfreq since now we have a subsequence can continue from 5"
     *
     *
     *
     * Now, explanation as of why it works
     * //
     * // How to solve?
     * //
     * // (e.g.) create sequence from (3,4,5,6,7), (5,6,7), (6,7,8,9,10)
     * //
     * //        -> 3, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 9, 10
     * //
     * //        visually we are solving
     * //
     * //                    *  *
     * //                 *  *  *
     * //           *  *  *  *  *  *  *  *
     * //           3  4  5  6  7  8  9  10
     * //
     * // we are creating open ended sequence as scanning through 3 to 10
     * //
     * // At 3, there is no open sequence so [3) will be created
     * //
     * // At 4, #(4) == #(open sequence)
     * //   so don't close the open sequences, just extends them
     * //    [3 4)
     * //
     * // At 5, #(5) > #(open sequences)  : (2 > 1)
     * //   so we extends existing open sequences, plus new sequence from '5'
     * //     [3 4 5)
     * //         [5)
     * //
     * // At 6, same situation as at '5',
     * //     [3 4 5 6)
     * //         [5 6)
     * //           [6)
     * //
     * // At 7, same as at 4 #(7) == #(seq)
     * //
     * //     [3 4 5 6 7)
     * //         [5 6 7)
     * //           [6 7)
     * //
     * // At 8, #(8) < #(seq) so we must close sequences if we can
     * //   (if not return false)
     * //
     * //     [3 4 5 6 7] --> done
     * //         [5 6 7] --> done
     * //           [6 7 8)
     * //
     * // At 9 and 10, we are just extending sequences
     * //           [6 7 8 9 10)
     * //
     * // At the end, if we can close all open sequences, return 'true'
     * // If not return 'false'
     * //
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i,0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            else if (appendfreq.getOrDefault(i,0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            }
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            }
            else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
