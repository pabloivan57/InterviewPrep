package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class RandomPickWithWeightTest {

    @Test
    public void test() {
        int[][] input = new int[][] {
                {},
                {}
        };

        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[] {1, 3});
        System.out.println(randomPickWithWeight.pickIndex());
    }
}
