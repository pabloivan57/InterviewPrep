package com.pablan.leetcode.medium;

public class HouseRobberII {

    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
     * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
     * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two
     * adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
     *              because they are adjacent houses.
     * Example 2:
     *
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     *
     * Pablo's notes: Redo but think about this way, this is the equivalent as two subproblems
     * 1.- If we rob house 1, then we cannot rob house n. The problem is reduced to [0... n - 1]
     * 2.- If we don't rob house 1, then we can rob house n. The problem now is [1...n];
     *
     * Pick the max of both
     */
    public int rob(int[] nums) {
       return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int n = start - end + 1;

        int dp[] = new int[n + 1];

        // case with no houses
        dp[0] = 0;

        // case with just 1 house
        dp[1] = nums[start];

        for(int i = 2; i <= end; i++) {
            // case 1 I don't steal this house
            int profit1 = dp[i - 1];

            // case 2 I steal this house
            int profit2 = nums[start + 2] + dp[i - 2];

            dp[i] = Math.max(profit1, profit2);
        }

        return dp[n];
    }
}
