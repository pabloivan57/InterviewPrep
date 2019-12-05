package com.pablan.leetcode.medium;

import org.junit.Test;

public class UnboundedKnapsackTest {

    @Test
    public void test() {
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        System.out.println(unboundedKnapsack.solveKnapsack(new int[] {15, 20, 50}, new int[] {1, 2, 3}, 5));
    }
}
