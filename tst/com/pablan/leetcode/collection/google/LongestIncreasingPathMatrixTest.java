package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class LongestIncreasingPathMatrixTest {

    @Test
    public void test() {

        int[][] matrix = new int[][] {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        LongestIncreasingPathMatrix longestIncreasingPathMatrix = new LongestIncreasingPathMatrix();
        System.out.println(longestIncreasingPathMatrix.longestIncreasingPath(matrix));
    }
}
