package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class MaximumSubRectangleIn2dMatrixTest {

    @Test
    public void test() {
        MaximumSubRectangleIn2dMatrix maximumSubRectangleIn2dMatrix = new MaximumSubRectangleIn2dMatrix();
        System.out.println(maximumSubRectangleIn2dMatrix.findMaxRectangleSum(new int[][] {
            {6,  -5, -7,  4, -4},
            {-9,  3, -6,  5,  2},
            {-10, 4,  7, -6,  3},
            {-8,  9, -3,  3, -7}
        })); // should be 17
    }
}
