package com.pablan.leetcode.medium;

public class MaximumCircularSubarray {

    /**
     * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
     *
     * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
     *
     * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
     *
     *
     *
     * Example 3:
     *
     * Input: [3,-1,2,-1]
     * Output: 4
     * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
     *
     * Here the trick is as follows:
     *
     * Max subarray = Max (Max subarray, Total - min Subarray)
     *
     * We have 2 scenarios here
     *
     * 1.- The maxSubarray is within the array. This is easy
     * 2.- The maxSubarray has elements from the tail and from the head. This is what we refer to rotated
     *
     * Now we align that this is true total_sum - maxSubarray = minSubarray. Perfect, the problem with rotated
     * array is that we cannot find it with kadane. BUT! the fact that maxSubarray might be on the tail / head
     * means that the min subarray is within the array. In other words
     *
     * Give maxSubarray => has elements from tail / head
     *
     * total_sum - maxSubarray = minSubarray OR total_sum - minSubarray = maxSubarray!!!
     *
     * We can do minSubarray with kadane because we know it's within the array. Cool, so now
     * going back to the question we simply go brute force and we try both scenarios
     *
     */
    public int maxSubarraySumCircular(int[] A) {
        int minSum = 0;
        int maxSum = 0;
        int total = 0;

        for(int i = 0; i < A.length; i++) {
            maxSum = Math.max(A[i], A[i] + maxSum);
            minSum = Math.min(A[i], A[i] + minSum);
            total += A[i];
        }

        int result = Math.max(maxSum, total - minSum);

        return result;
    }
}
