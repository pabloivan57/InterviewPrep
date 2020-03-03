package com.pablan.leetcode.medium;

public class CoinChange {

    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Example 1:
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * Example 2:
     *
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     */
    public int coinChange(int[] coins, int amount) {
        int result = coinChangeRecursive(coins, 0, 0, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChangeRecursive(int[] coins, int index, int coinAmount, int amount) {
        if(amount == 0) {
            return coinAmount;
        }

        if(amount < 0 || index >= coins.length) {
            return Integer.MAX_VALUE;
        }

        // skip
        int case1 = coinChangeRecursive(coins, index + 1, coinAmount, amount);
        // pick
        int case2 = coinChangeRecursive(coins, index, coinAmount + 1, amount - coins[index]);

        return Math.min(case1, case2);
    }
}
