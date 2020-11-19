package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class OptimalAccountBalancingTest {

    @Test
    public void test() {
        OptimalAccountBalancing optimalAccountBalancing = new OptimalAccountBalancing();
        System.out.println(optimalAccountBalancing.minTransfers(new int[][] {{0,1,10}, {2,0,5}})); // should be 2
    }
}
