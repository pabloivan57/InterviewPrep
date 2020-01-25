package com.pablan.leetcode.collection.google;

import org.junit.Test;

import java.util.Arrays;

public class NextPermutationTest {

    @Test
    public void test() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] array = new int[] {1, 2, 3};
        nextPermutation.nextPermutation(array);

        System.out.println(Arrays.toString(array)); // should be 1,3,2
    }
}
