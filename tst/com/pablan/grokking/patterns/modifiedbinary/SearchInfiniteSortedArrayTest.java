package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class SearchInfiniteSortedArrayTest {

    @Test
    public void test() {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(new SearchInfiniteSortedArray().search(reader, 16));
        System.out.println(new SearchInfiniteSortedArray().search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(new SearchInfiniteSortedArray().search(reader, 15));
        System.out.println(new SearchInfiniteSortedArray().search(reader, 200));
    }
}
