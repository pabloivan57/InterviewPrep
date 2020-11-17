package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class SmallestSubarrayContiguousGivenSumTest {

    @Test
    public void test() {
        SmallestSubarrayContiguousGivenSum smallestSubarrayContiguousGivenSum = new SmallestSubarrayContiguousGivenSum();
        System.out.println(smallestSubarrayContiguousGivenSum.findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));
    }
}
