package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class MagicSquaresInGridTest {

    @Test
    public void test() {
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();

        System.out.println(magicSquaresInGrid.numMagicSquaresInside(new int[][] {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));
    }
}
