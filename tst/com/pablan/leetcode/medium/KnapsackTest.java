package com.pablan.leetcode.medium;

import org.junit.Test;

public class KnapsackTest {

    @Test
    public void test() {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.solveKnapsack(new int[] {1, 6, 10, 16}, new int[] {1, 2, 3, 5}, 7));
    }
}
