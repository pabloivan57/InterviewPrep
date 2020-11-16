package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class MaxSumSubarrayContiguousSizeKTest {

    @Test
    public void test() {
        MaxSumSubarrayContiguousSizeK maxSumSubarrayContiguousSizeK = new MaxSumSubarrayContiguousSizeK();
        System.out.println(maxSumSubarrayContiguousSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2})); // should be 9
    }
}
