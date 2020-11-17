package com.pablan.grokking.patterns.sliding;

public class SmallestSubarrayContiguousGivenSum {

    /**
     *  Given an array of positive numbers and a positive number ‘S,’
     *  find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
     *
     *  Return 0 if no such subarray exists.
     *
     *  Input: [2, 1, 5, 2, 3, 2], S=7
     *  Output: 2
     *  Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
     *
     */
    public int findMinSubArray(int S, int[] arr) {
        int sum = 0;
        int windowStart = 0;
        int minSize = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            // slide window
            while(sum >= S) {
                if(minSize > windowEnd - windowStart + 1) {
                    minSize = windowEnd - windowStart + 1;
                }
                sum -= arr[windowStart++];
            }

        }

        return minSize;
    }
}
