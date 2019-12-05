package com.pablan.leetcode.medium;

import java.util.Arrays;

public class Knapsack {

    /**
     *  Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of
     *  these items which will give us maximum profit such that their
     *  cumulative weight is not more than a given number ‘C’. Each item can only be selected once,
     *  which means either we put an item in the knapsack or we skip it.
     *
     *  Pablo's notes: You have to be careful when using the capacity for the second dimension
     *  if you do something like if capacity - weights[i] >= 0 then you're working with 1 index, not 0
     *  because of that if you iterate with for(int c = 1; c < capacity; c++). Then you will be calculating up until
     *  capacity - 1, or from the example above up to 4. This is the explanation why we use capacity + 1 when creating dp
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        solveKnapsackNaive(0, capacity, profits, weights);

        int[][] dp = new int[profits.length][capacity + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], - 1);
        }
        solveKnapsackMemo(0, capacity, profits, weights, dp);
        return solveKnapsackBottomUp(profits, weights, capacity);
    }

    private int solveKnapsackNaive(int index, int capacity, int[] profits, int[] weights) {
        if(capacity <= 0 || index > profits.length - 1) {
            return 0;
        }

        // case 1: select item
        int profit1 = 0;
        if(weights[index] <= capacity) {
            // I can select the item
            profit1 = profits[index] + solveKnapsackNaive(index + 1, capacity - weights[index], profits, weights);
        }
        // case 2: skip the item
        int profit2 = solveKnapsackNaive(index + 1, capacity, profits, weights);

        return Math.max(profit1, profit2);
    }

    private int solveKnapsackMemo(int index, int capacity, int[] profits, int[] weights, int[][] dp) {
        // base case
        if(capacity <= 0 || index > profits.length - 1) {
            return 0;
        }

        // if max given capacity is not in memory
        if(dp[index][capacity] == -1) {
            // case 1: select item
            int profit1 = 0;
            if(weights[index] <= capacity) {
                // I can select the item
                profit1 = profits[index] + solveKnapsackNaive(index + 1, capacity - weights[index], profits, weights);
            }
            // case 2: skip the item
            int profit2 = solveKnapsackNaive(index + 1, capacity, profits, weights);

            dp[index][capacity] = Math.max(profit1, profit2);
        }

        return dp[index][capacity];
    }

    private int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        int dp[][] = new int[profits.length][capacity + 1];

        // Initialize base cases
        // With 0 capacity
        for(int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        // With just 1 element
        for(int j = 1; j <= capacity; j++) {
            // If there is one element, take if if not more than capacity
            if(weights[0] <= capacity) {
                dp[0][j] = profits[0];
            }
        }

        // calculate table
        for(int i = 1; i < profits.length; i++) {
            for(int j = 1; j <= capacity; j++) {
                int profit1 = 0, profit2 = 0;

                // Case 1, we select element if there is capacity
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[i - 1][j - weights[i]];
                }

                // Case 2, we skip element
                profit2 = dp[i - 1][j];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[profits.length - 1][capacity];
    }
}
