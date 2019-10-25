package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

public class PairWithTargetSumTest {

    @Test
    public void test() {
        PairWithTargetSum pairWithTargetSum = new PairWithTargetSum();
        int[] result = pairWithTargetSum.solve(new int[] {2, 5, 9, 11}, 11);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
