package com.pablan.leetcode.easy;

public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */
    public int climbStairs(int n) {
        return climbStairsBottomUp(n);
    }

    public int climbStairsBottomUp(int n) {
        int[] dp = new int[n + 1];

        // with no steps there are no ways
        dp[0] = 1;
        // with 1 step only 1 way, 1 step
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            // number of ways if I took 2 steps in this last step, + number of ways if I took 1
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
