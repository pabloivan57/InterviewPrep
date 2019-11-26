package com.pablan.leetcode.medium;

import org.junit.Test;

public class PacificAtlanticFlowTest {

    @Test
    public void test() {
        PacificAtlanticFlow pacificAtlanticFlow = new PacificAtlanticFlow();
        int[][] matrix = new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4},
        };

        System.out.println(pacificAtlanticFlow.pacificAtlantic(matrix));
    }
}
