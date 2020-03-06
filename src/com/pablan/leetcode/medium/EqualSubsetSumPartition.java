package com.pablan.leetcode.medium;

public class EqualSubsetSumPartition {

    /**
     * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
     * such that the sum of elements in both subsets is equal.
     *
     * Note:
     *
     * Each of the array element will not exceed 100.
     * The array size will not exceed 200.
     *
     *
     * Example 1:
     *
     * Input: [1, 5, 11, 5]
     *
     * Output: true
     *
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     *
     *
     * Example 2:
     *
     * Input: [1, 2, 3, 5]
     *
     * Output: false
     *
     * Explanation: The array cannot be partitioned into equal sum subsets.
     */
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0) {
            // we cannot have two subsets with the same value (because we are working with integers)
            return false;
        }

        return canPartition(totalSum / 2, 0, nums);
    }

    public boolean canPartition(int targetSum, int index, int[] nums) {
        // If there is a sum that equals our target sum, we found a subset
        if(targetSum == 0) {
            return true;
        }

        if(index >= nums.length) {
            return false;
        }

        // Option one: currentIndex is part of equal subset
        boolean option1 = canPartition(targetSum - nums[index], index + 1, nums);

        // Option two: skip element
        boolean option2 = canPartition(targetSum, index + 1, nums);

        return option1 || option2;
    }

    public boolean canPartitionBottomUp(int targetSum, int[] nums) {
        boolean[][] dp = new boolean[nums.length][targetSum + 1];

        // with just one element
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == targetSum) {
                dp[i][0] = true;
            }
        }

        // build table
        // for each "capacity" (knapsack pattern) check if I can choose the number
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j < targetSum; j++) {
                // if I can pick this number
                boolean option1 = false;
                boolean option2 = false;
                if(nums[i] < j) {
                    option1 = dp[i - 1][j - nums[i]];
                }

                // case2 skip it
                option2 = dp[i - 1][j];

                dp[i][j] = option1 || option2;
            }
        }

        return dp[nums.length][targetSum];
    }
}
