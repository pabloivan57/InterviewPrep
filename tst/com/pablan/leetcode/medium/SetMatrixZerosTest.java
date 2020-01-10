package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class SetMatrixZerosTest {

    @Test
    public void test() {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int[][] matrix1 = new int[][] {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZeros.setZeroes(matrix1);

        for(int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }
}
