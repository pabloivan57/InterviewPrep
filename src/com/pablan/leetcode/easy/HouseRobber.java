package com.pablan.leetcode.easy;

public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
     * is that adjacent houses have security system connected and it will automatically contact the police if
     * two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     *
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     *              Total amount you can rob = 2 + 9 + 1 = 12.
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int dp[] = new int[nums.length + 1];

        // With no houses there is no profit for the robber
        dp[0] = 0;
        // With only one house the profit is to rob that house
        dp[1] = nums[0];

        for(int i = 2; i <= nums.length; i++) {
            // case 1, I didn't steal house 2
            int profit1 = dp[i - 1];

            // case 2, I stole house 2
            int profit2 = nums[i - 1] + dp[i - 2];

            dp[i] = Math.max(profit1, profit2);
        }

        return dp[nums.length];
    }
}
