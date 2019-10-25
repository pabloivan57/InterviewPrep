package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class SearchBitonicArrayTest {

    @Test
    public void test() {
        System.out.println(new SearchBitonicArray().search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(new SearchBitonicArray().search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(new SearchBitonicArray().search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(new SearchBitonicArray().search(new int[] { 10, 9, 8 }, 10));
    }
}
