package com.pablan.leetcode.easy;

import java.util.Arrays;

public class Fibonacci {

    /**
     * Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers.
     * First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, …
     *
     * Mathematically we can define the Fibonacci numbers as:
     *
     * Fib(n) = Fib(n-1) + Fib(n-2), for n > 1
     *
     * Given that: Fib(0) = 0, and Fib(1) = 1
     *
     */
    public int fib(int n) {
        //fibRecursive(n);
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        //fibMemoization(n, dp);
        return fibBottomUp(n);
    }

    public int fibRecursive(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public int fibMemoization(int n, int[] dp) {
        // base cases
        if(n == 0) {
            dp[0] = 0;

        } else if(n == 1) {
            dp[1] = 1;
        } else if(dp[n] == -1) {
          dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
        }

        return dp[n];
    }

    public int fibBottomUp(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
