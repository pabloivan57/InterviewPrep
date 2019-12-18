package com.pablan.leetcode.medium;

import org.junit.Test;

public class MaximumCircularSubarrayTest {

    @Test
    public void test() {
        MaximumCircularSubarray maximumCircularSubarray = new MaximumCircularSubarray();
        System.out.println(maximumCircularSubarray.maxSubarraySumCircular(new int[] {3,-1,2,-1}));
    }
}
