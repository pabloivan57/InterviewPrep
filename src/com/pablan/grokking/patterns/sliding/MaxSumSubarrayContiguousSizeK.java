package com.pablan.grokking.patterns.sliding;

public class MaxSumSubarrayContiguousSizeK {

    /**
     *  Given an array of positive numbers and a positive number ‘k,’
     *  find the maximum sum of any contiguous subarray of size ‘k’.
     *
     *  Input: [2, 1, 5, 1, 3, 2], k=3
     *  Output: 9
     *  Explanation: Subarray with maximum sum is [5, 1, 3].
     *
     *  Input: [2, 3, 4, 1, 5], k=2
     *  Output: 7
     *  Explanation: Subarray with maximum sum is [3, 4].
     */
    public int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowStart = 0;
        int sum = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            while (windowEnd - windowStart + 1 > k) {
                sum -= arr[windowStart++];
            }

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
