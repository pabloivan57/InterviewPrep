package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class CherryPickupIITest {

    @Test
    public void test() {
        CherryPickupII cherryPickupII = new CherryPickupII();
        int[][] grid = new int[][] {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };

        System.out.println(cherryPickupII.cherryPickup(grid)); // Should be 24
    }
}
