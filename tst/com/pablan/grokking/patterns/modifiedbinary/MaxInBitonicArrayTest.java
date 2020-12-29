package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class MaxInBitonicArrayTest {

    @Test
    public void test() {
        System.out.println(new MaxInBitonicArray().findMax(new int[] { 1, 3, 8, 12, 4, 2 })); // should be 12
        System.out.println(new MaxInBitonicArray().findMax(new int[] { 3, 8, 3, 1 })); // should be 8
        System.out.println(new MaxInBitonicArray().findMax(new int[] { 1, 3, 8, 12 })); // should be 8
        System.out.println(new MaxInBitonicArray().findMax(new int[] { 10, 9, 8 })); // should be 10
    }
}
