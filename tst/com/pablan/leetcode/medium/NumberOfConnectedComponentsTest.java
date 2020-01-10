package com.pablan.leetcode.medium;

import org.junit.Test;

public class NumberOfConnectedComponentsTest {

    @Test
    public void test() {
        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        System.out.println(numberOfConnectedComponents.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(numberOfConnectedComponents.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        System.out.println(numberOfConnectedComponents.countComponents(2, new int[][] {{1, 0}}));
        System.out.println(numberOfConnectedComponents.countComponents(4, new int[][] {{2,3},{1,2},{1,3}}));
    }
}
