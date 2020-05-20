package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class MaxSumOfRectangleNoLargerThanKTest {

    @Test
    public void test() {
        MaxSumOfRectangleNoLargerThanK maxSumOfRectangleNoLargerThanK = new MaxSumOfRectangleNoLargerThanK();
        System.out.println(maxSumOfRectangleNoLargerThanK.maxSumSubmatrix(new int[][] {
                {1,0,1},
                {0,-2,3},
        }, 2)); // Should be 2
    }
}
