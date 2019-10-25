package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class MinimumDifferenceTest {

    @Test
    public void test() {
        System.out.println(new MinimumDifference().searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(new MinimumDifference().searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(new MinimumDifference().searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(new MinimumDifference().searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
