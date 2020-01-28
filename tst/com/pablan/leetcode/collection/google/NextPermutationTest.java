package com.pablan.leetcode.collection.google;

import org.junit.Test;

import java.util.Arrays;

public class NextPermutationTest {

    @Test
    public void test() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] array = new int[] {1, 2, 3};
        int[] array2 = new int[] {3, 2, 1};
        int[] array3 = new int[] {1, 1, 5};
        nextPermutation.nextPermutation(array);
        nextPermutation.nextPermutation(array2);
        nextPermutation.nextPermutation(array3);

        System.out.println(Arrays.toString(array)); // should be 1,3,2
        System.out.println(Arrays.toString(array2)); // should be 1,2,3
        System.out.println(Arrays.toString(array3)); // should be 1,5,1
    }
}
