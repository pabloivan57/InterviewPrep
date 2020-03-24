package com.pablan.leetcode.medium;

import org.junit.Test;

public class MaximumSwapTest {

    @Test
    public void test() {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(2736)); // should be 7236
        System.out.println(maximumSwap.maximumSwap(9973)); // should be 9973
        System.out.println(maximumSwap.maximumSwap(98368)); // should be 98863
    }
}
