package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i >= 1) {
                if(nums[i - 1] == nums[i]) {
                    // In this case we are going to try to find same target (chances we will get same triplet)
                    // so we skip
                    continue;
                }
            }

            findTriplet(i + 1, -nums[i], nums, result);
        }

        return result;
    }

    private void findTriplet(int start, int target, int[] nums, List<List<Integer>> result) {
        int p1 = start;
        int p2 = nums.length - 1;

        while(p1 < p2) {
            int sum = nums[p1] + nums[p2];

            if(sum == target) {
                // found a triplet
                List<Integer> triplet = new ArrayList<>();
                triplet.add(-target);
                triplet.add(nums[p1]);
                triplet.add(nums[p2]);

                result.add(triplet);
                // attempt to find another triplet in same set
                p1++;
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }
    }
}
