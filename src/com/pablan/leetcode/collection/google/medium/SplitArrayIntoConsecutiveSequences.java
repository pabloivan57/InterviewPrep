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
     * Pablo's notes: The intuition behind it is a follows:
     * 1.- Try to make sure you have at least  a sequence of 3,
     * 2.- Once you do try extending that sequence, but if at any point
     *      you find another 3  sequences, make sure you get that as well
     *      and now try to extend both.
     *
     * 3.- To accomplish extending sequences you keep a 'buffer' of possible
     *     extension points, and when you find a number that qualifies simply
     *     add it to an existing sequence.
     *
     * From the moment you found the first 3 sequence you prioritize extending it,
     * that's why this algorithm it's 'greedy"
     *
     * From leetcode:
     *
     * "I was super confused also so I paste and ran the code through example 1 and 2.
     * What I learned is the appendFreq is use for tracking of numbers that can use to extend existence subsequences
     * (could be name more like: numberNeedForExtendingExistingSubSeq).
     * For example 1, the code will decrement frequency for 1, 2, 3 because that form a subsequence of at
     * least length 3, and put 4 on the appendFreq (the number that can extend the subsequence).
     * The code always prioritizes extending existing subsequences over creating new subsequence.
     * So when the code get to nummber 4, it adds 4 to the existing sequence by decrementing frequency by 1 and
     * mark 5 as the next number that can extends the subsequence by putting it on the appendFreq.
     * Instead of generating subsequences until the frequency of numbers runs out to check for valid,
     * the code check for condition in which a number cannot become a subsequence of length of three or cannot be use
     * to append to existing subsequences."
     *
     * The perfect example is
     *
     * 1 2 3 3 4 4 5 5
     *
     * Visually it looks like
     *
     *      * * *
     *  * * * * *
     *  1 2 3 4 5
     *
     *  so you look at 1 and notice there is a possible 3 sequence
     *
     *  1, 2, 3
     *
     *  then you move to 3 and notice there is another 3 sequence
     *
     *  3, 4, 5
     *
     *  now you go to 3 and notice... you can't make another 3 sequence but you can
     *  add to previous
     *
     *  1, 2 , 3, 4. However, now I'm missing a 5 so I try to find it and mark it
     *  as an extension point
     *
     *  now you go to 5 and notice... you can add to previous sequence
     *
     *  1, 2, 3, 4, 5. And you're done going through all numbers
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        // Count occurrences
        for (int i = 0; i < nums.length; i++) {
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> seqExtensionPossibilities = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurrences.get(nums[i]) == 0) continue;
            if (seqExtensionPossibilities.getOrDefault(i, 0) > 0) {
                // This number could be added to a previous sequence, see next block
                seqExtensionPossibilities.put(i, seqExtensionPossibilities.get(i) - 1);
                // Add next number in the sequence to possibilities
                seqExtensionPossibilities.put(i + 1, seqExtensionPossibilities.getOrDefault(i + 1, 0) + 1);
            } else if (occurrences.get(nums[i]) > 0
                    && occurrences.getOrDefault(nums[i + 1], 0) > 0
                    && occurrences.getOrDefault(nums[i + 1], 0) > 0) {
                // We can create a sequence of minimum 3
                occurrences.put(nums[i] + 1, occurrences.get(nums[i] + 1) - 1);
                occurrences.put(nums[i] + 2, occurrences.get(nums[i] + 2) - 1);
                // The number that could extends this sequence is
                seqExtensionPossibilities.put(nums[i] + 3, 1);
            } else {
                // there is a number that can't go into sequence or create a new one, return false
                return false;
            }
            occurrences.put(i, occurrences.get(i) - 1);
        }

        return true;
    }
}
