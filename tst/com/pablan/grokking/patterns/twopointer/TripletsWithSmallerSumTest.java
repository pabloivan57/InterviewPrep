package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

public class TripletsWithSmallerSumTest {

    @Test
    public void test() {
        TripletsWithSmallerSum tripletsWithSmallerSum = new TripletsWithSmallerSum();
        System.out.println(tripletsWithSmallerSum.solve(new int[] {-1, 4, 2, 1, 3}, 5));
    }
}
