package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class MinCostToMakeAtLeastOneValidPathInAGridTest {

    @Test
    public void test() {
        MinCostToMakeAtLeastOneValidPathInAGrid minCostToMakeAtLeastOneValidPathInAGrid = new MinCostToMakeAtLeastOneValidPathInAGrid();
        System.out.println(minCostToMakeAtLeastOneValidPathInAGrid.minCost(new int[][] {
                {1,1,1,1},
                {2,2,2,2},
                {1,1,1,1},
                {2,2,2,2}
        }));
    }
}
