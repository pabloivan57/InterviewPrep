package com.pablan.leetcode.medium;

import org.junit.Test;

public class MaximumProductSubarrayTest {

    @Test
    public void test() {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[] {2,3,-2,4}));
        System.out.println(maximumProductSubarray.maxProduct(new int[] {-2,0,-1}));
    }
}
