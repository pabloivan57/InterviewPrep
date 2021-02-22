package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class CountSquareSubMatricesWithAllOnesTest {

    @Test
    public void test() {
        CountSquareSubMatricesWithAllOnes countSquareSubMatricesWithAllOnes = new CountSquareSubMatricesWithAllOnes();
        System.out.println(countSquareSubMatricesWithAllOnes.countSquares(new int[][] {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        })); // should be 15

        System.out.println(countSquareSubMatricesWithAllOnes.countSquares(new int[][] {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        })); // should be 7
    }
}
