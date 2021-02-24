package com.pablan.leetcode.collection.google.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Given an array of integers and an integer k,
     * you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     *
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     *
     * Related Exercise 'FindTwoOverlappingSubArraysWithTarget'
     *
     * Pablo's notes: This is tricky because at first glance it seems like it's sliding window,
     * but it fails, it fails when we have negative numbers on it.
     * This is another technique that deals with proportions
     *
     * "Keep track of the sum so far, and track the sums so far in a dictionary that tracks how many times we have
     * seen a particular sum.
     * Then, when you think about it, you can see that whenever we reach our desired sum,
     * we can increment the number of subarrays by 1
     * Also, if the number our_sum - k has been seen before, that means that a subarray (starting with index 0)
     * makes that sum. So if we subtract those subarrays from the current subarray,
     * we are left with a subarray that adds up to k. Therefore, we can add that many more to the number of subarrays."
     *
     */
    public int subarraySum(int[] nums, int k) {

    }
}
