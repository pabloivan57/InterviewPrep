package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.intervals.Interval;

public class BuySellStockII {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Example 2:
     *
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     *              engaging multiple transactions at the same time. You must sell before buying again.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int valley = prices[0];
        int peak = 0;
        int i = 1;
        while (i < prices.length) {
            while( i < prices.length && valley > prices[i]) {
                valley = prices[i++];
            }
            peak = valley;
            while( i < prices.length && prices[i] > peak) {
                peak = prices[i++];
            }

            maxProfit += peak - valley;
            valley = peak;
        }

        return maxProfit;
    }
}
