package com.pablan.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * Your algorithm should run in O(n) complexity.
     *
     * Example:
     *
     * Input: [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Pablo's notes: The idea is to find the beginning of those sequences. You check if the number before current
     * is present to discard finding a number part of a sequence. For example: 100, is there a 99? No, ok so this is a
     * sequence... we proceed. Is there a 101? Nope, ok so this was a sequence 1
     *
     * In the case of 4, is there a 3? Yes, is there a 2? Yes, is there a 1? Yes, is there a 0? nope... the proceed
     * 1, 2, 3, 4 --> there is no 5, ok so max length is 4
     *
     * In the case of 200 is the same as 100, Then in the case of 1 we already have that one! (Hint: this is optimized
     * by dynamic programming solution) but this algorithm calculates it again, we do the same with 3 and 2. Max length
     * is 4
     *
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for(int num : numSet) {
            if(!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while(numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
