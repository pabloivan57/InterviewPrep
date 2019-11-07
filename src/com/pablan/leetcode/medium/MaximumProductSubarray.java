package com.pablan.leetcode.medium;

public class MaximumProductSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * Example 1:
     *
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     * Pablo's notes: The way I looked at this problem is as follows.
     * You have three choices to make at any position in array.
     * 1. You can get maximum product by multiplying the current element with
     *     maximum product calculated so far.  (might work when current
     *     element is positive).
     * 2. You can get maximum product by multiplying the current element with
     *     minimum product calculated so far. (might work when current
     *     element is negative).
     * 3.  Current element might be a starting position for maximum product sub
     *      array
     *
     *     so you have to maintain current maximum product and current
     *     minimum product.
     */
    public int maxProduct(int[] nums) {
        int[] maxSoFar = new int[nums.length];
        int[] minSoFar = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                maxSoFar[i] = nums[i];
                minSoFar[i] = nums[i];
                continue;
            }

            maxSoFar[i] = Math.max(nums[i], Math.max(maxSoFar[i - 1] * nums[i], minSoFar[i - 1] * nums[i]));
            minSoFar[i] = Math.min(nums[i], Math.min(maxSoFar[i - 1] * nums[i], minSoFar[i - 1] * nums[i]));
        }

        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < maxSoFar.length; i++) {
            maxProduct = Math.max(maxSoFar[i], maxProduct);
        }

        return maxProduct;
    }
}
