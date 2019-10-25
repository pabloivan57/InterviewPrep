package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

public class TripletSumCloseToTargetTest {

    @Test
    public void test() {
        TripletSumCloseToTarget tripletSumCloseToTarget = new TripletSumCloseToTarget();

        System.out.println(tripletSumCloseToTarget.solve(new int[] {-1, 4, 1, 2}, 2));
    }
}
