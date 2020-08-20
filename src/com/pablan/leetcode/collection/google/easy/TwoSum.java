package com.pablan.leetcode.collection.google.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(complements.containsKey(complement)) {
                // found a solution
                return new int[] {i, complements.get(complement)};
            }

            complements.put(nums[i], i);
        }

        return new int[]{};
    }
}
