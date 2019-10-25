package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

import java.util.Arrays;

public class SquareSortedArrayTest {

    @Test
    public void test() {
        SquareSortedArray squareSortedArray = new SquareSortedArray();
        int[] squares = new int[] {-2, -1, 0, 2, 3};
        System.out.println(Arrays.toString(squares));
        int[] result = squareSortedArray.makeSquares(squares);
        System.out.println(Arrays.toString(result));
    }
}
