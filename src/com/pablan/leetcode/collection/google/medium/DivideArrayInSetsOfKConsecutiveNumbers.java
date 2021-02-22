package com.pablan.leetcode.collection.google.medium;

import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {

    /**
     * Given an array of integers nums and a positive integer k,
     * find whether it's possible to divide this array into sets of k consecutive numbers
     * Return True if its possible otherwise return False.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,3,4,4,5,6], k = 4
     * Output: true
     * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
     * Example 2:
     *
     * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
     * Output: true
     * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
     * Example 3:
     *
     * Input: nums = [3,3,2,2,1,1], k = 3
     * Output: true
     * Example 4:
     *
     * Input: nums = [1,2,3,4], k = 3
     * Output: false
     * Explanation: Each array should be divided in subarrays of size 3.
     *
     * Note: This is the same exercise as a hand of straights
     *
     * You could do this with a Hashmap, but it's definitely more elegant to
     * use a Treemap. Remember, a treemap keeps a hashmap but with ordered keys
     *
     * More information. The key here is keep track of occurrences. Now ask,
     * for the smallest number in the set. Can I find the consecutives i + 2 and i + 3.. i + k?
     *
     * Cool, if one of the occurrences reach 0 then remove it.
     * Now, do this until you have no more occurrences, at any point in time if you don't have
     * i + 2, i + 3... i + k then return false.
     *
     * For example:
     *
     * 3,3,2,2,1,1
     *
     * 3 --> 2
     * 2 --> 2   k = 3
     * 1 --> 2
     *
     * Get the smallest, 1. Do I have i + 1 and i + 2. Yes I do, then remove occurrences for them
     *
     * 3 -> 1
     * 2 -> 1
     * 1 -> 1
     *
     * Get the smallest again, 1. Fo I have i + 1, i + 2. Yes, cool then remove the values from the occurrences
     *
     * []
     *
     * Since occurrences is empty I managed to fit in all numbers in consecutive sequences of k.
     *
     * TreeMap is easy to use here because it keeps a sorted map. Otherwise you could have sorted the array as well
     *
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> occurrences = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
        }

        while(!occurrences.isEmpty()) {
            int smallest = occurrences.firstKey();

            for(int j = smallest; j < smallest + k; j++) {
                if(!occurrences.containsKey(j)) {
                    return false;
                }

                occurrences.put(j, occurrences.get(j) - 1);

                // If I don't have any more remove it from the occurrences map
                if(occurrences.get(j) == 0) {
                    occurrences.remove(j);
                }
            }
        }

        return true;
    }
}
