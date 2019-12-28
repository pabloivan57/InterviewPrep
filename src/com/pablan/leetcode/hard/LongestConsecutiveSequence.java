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
     * Note: This example would help understad
     *
     * "wouldn't [100,99, 98, ..., 1] (i.e. an array in reverse order)
     * make this run in $$O(n^2)$$ because for every num, it have to go through the entire set so far?"
     *
     * ""
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
