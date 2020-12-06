package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class PathWithMaximumMinimumValueTest {

    @Test
    public void test() {
        PathWithMaximumMinimumValue pathWithMaximumMinimumValue = new PathWithMaximumMinimumValue();
        int[][] grid = new int[][] {
                {5,4,5},
                {1,2,6},
                {7,4,6}
        };
        System.out.println(pathWithMaximumMinimumValue.maximumMinimumPath(grid)); // should be 4
    }
}
