package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class RottingOrangesTest {

    @Test
    public void test() {
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));
    }
}
