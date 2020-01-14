package com.pablan.leetcode.collection.hard;

import org.junit.Test;

import java.util.Arrays;

public class SpiralMatrixTest {

    @Test
    public void test() {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(spiralMatrix.spiralOrder(matrix));

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
