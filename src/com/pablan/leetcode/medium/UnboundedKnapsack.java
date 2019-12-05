package com.pablan.leetcode.medium;

import java.util.Arrays;

public class UnboundedKnapsack {

    /**
     * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an unlimited quantity of an item.
     *
     * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
     *
     * Items: { Apple, Orange, Melon }
     * Weights: { 1, 2, 3 }
     * Profits: { 15, 20, 50 }
     * Knapsack capacity: 5
     *
     * Pablo's notes: You have to be careful when using the capacity for the second dimension
     * if you do something like if capacity - weights[i] >= 0 then you're working with 1 index, not 0
     * because of that if you iterate with for(int c = 1; c < capacity; c++). Then you will be calculating up until
     * capacity - 1, or from the example above up to 4. This is the explanation why we use capacity + 1 when creating dp
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        int dp[][] = new int[profits.length][capacity];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solveKnapsack(0, profits, weights, capacity);
        solveKnapsackMemo(0, profits, weights, capacity, dp);
        return solveKnapsackBottomUp(profits, weights, capacity);
    }

    private int solveKnapsack(int currentIndex, int[] profits, int[] weights, int capacity) {
        if(capacity <= 0 || currentIndex > profits.length - 1) {
            return 0;
        }

        // Case 1: pick current element
        int profit1 = 0;
        if(weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + solveKnapsack(currentIndex, profits, weights, capacity - weights[currentIndex]);
        }

        // Case2: skip current element
        int profit2 = solveKnapsack(currentIndex + 1, profits, weights, capacity);

        return Math.max(profit1, profit2);
    }

    private int solveKnapsackMemo(int currentIndex, int[] profits, int[] weights, int capacity, int[][] dp) {
        if(capacity <= 0 || currentIndex > profits.length - 1) {
            return 0;
        }

        if(dp[currentIndex][capacity - 1] == -1) {
            // Case 1: pick current element
            int profit1 = 0;
            if(weights[currentIndex] <= capacity) {
                profit1 = profits[currentIndex] + solveKnapsack(currentIndex, profits, weights, capacity - weights[currentIndex]);
            }

            // Case2: skip current element
            int profit2 = solveKnapsack(currentIndex + 1, profits, weights, capacity);

            dp[currentIndex][capacity - 1] = Math.max(profit1, profit2);
        }

        return dp[currentIndex][capacity - 1];
    }

    private int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        int dp[][] = new int[profits.length][capacity + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Base cases, capacity is 0
        for(int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        // Build table
        for(int i = 0; i < profits.length; i++) {
            for(int j = 1; j <= capacity; j++) {

                int profit1 = 0;
                // Case 1, we pick the weight if there is capacity
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[i][j - weights[i]];
                }

                // Case 2, we skip it
                int profit2 = 0;
                if(i > 0) {
                    profit2 = dp[i - 1][j];
                }

                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[profits.length - 1][capacity];
    }
}
