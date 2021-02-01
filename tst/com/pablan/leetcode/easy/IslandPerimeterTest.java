package com.pablan.leetcode.easy;

import org.junit.Test;

public class IslandPerimeterTest {

    @Test
    public void test() {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.print(islandPerimeter.islandPerimeter(new int[][] {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
}
