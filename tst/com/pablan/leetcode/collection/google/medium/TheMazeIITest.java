package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class TheMazeIITest {

    @Test
    public void test() {
        TheMazeII theMazeII = new TheMazeII();
        int[][] grid = new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(theMazeII.shortestDistance(grid, new int[]{0, 4}, new int[] {4, 4})); // should be 12
    }
}
