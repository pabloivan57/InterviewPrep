package com.pablan.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
     * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // What the problem is telling us is to focus on
        // i - j <= k || j - i <= k

        Set<Integer> ocurrences = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(ocurrences.contains(nums[i])) {
                return true;
            }
            ocurrences.add(nums[i]);
            if (ocurrences.size() > k) {
                ocurrences.remove(nums[k - i]);
            }
        }

        return false;
    }
}
