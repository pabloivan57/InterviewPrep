package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class RangeSumQuery2DImmutableTest {

    @Test
    public void test() {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        RangeSumQuery2DImmutable rangeSumQuery2DImmutable = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3)); // Should be 8

    }
}
