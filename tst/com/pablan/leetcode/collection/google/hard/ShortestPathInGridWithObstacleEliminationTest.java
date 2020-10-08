package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class ShortestPathInGridWithObstacleEliminationTest {

    @Test
    public void test() {
        ShortestPathInGridWithObstacleElimination shortestPathInGridWithObstacleElimination = new ShortestPathInGridWithObstacleElimination();

        int[][] grid = new int[][] {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        System.out.println(shortestPathInGridWithObstacleElimination.shortestPath(grid, 1)); // Should be 6
    }
}
