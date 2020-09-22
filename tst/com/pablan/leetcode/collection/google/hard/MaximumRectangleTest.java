package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class MaximumRectangleTest {

    @Test
    public void test() {
        MaximumRectangle maximumRectangle = new MaximumRectangle();
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maximumRectangle.maximalRectangle(matrix)); // should be 6
    }
}
