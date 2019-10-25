package com.pablan.leetcode.medium;

import org.junit.Test;

public class NumberOfIslandsTest {

    @Test
    public void test() {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(new char[][] {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        }));
    }
}
