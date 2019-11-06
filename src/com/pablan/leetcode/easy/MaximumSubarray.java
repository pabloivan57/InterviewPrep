package com.pablan.leetcode.easy;

public class MaximumSubarray {

    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Note: This problem looks like Sliding window, but it's not...

    Look at this explanation:

    current element = [-2,1,-3,4,-1,2,1,-5,4]
    current max sum = [-2,1,-2,4,3,5,6,1,5]
    max seen so far from max sum = [-2,1,1,4,4,5,6,6,6] --> last one is the answer
     */
    public int maxSubArray(int[] nums) {
        int[] maxSums = new int[nums.length];
        // Initialize first element
        maxSums[0] = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1] + nums[i], nums[i]);
            if(maxSums[i] > maxSum) {
                maxSum = maxSums[i];
            }
        }

        return maxSum;
    }
}
