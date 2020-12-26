package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class ConstrainedSubsequenceSumTest {

    @Test
    public void test() {
        ConstrainedSubsequenceSum constrainedSubsequenceSum = new ConstrainedSubsequenceSum();
        System.out.println(constrainedSubsequenceSum.constrainedSubsetSum(new int[] {10,2,-10,5,20}, 2)); // should be 10, 2, 5, 20 = 37
    }
}
