package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class SearchRotatedArrayTest {

    @Test
    public void test() {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        System.out.println(searchRotatedArray.search(new int[] {10, 15, 1, 3, 8}, 15)); // should be 1
        System.out.println(searchRotatedArray.search(new int[] {4, 5, 7, 9, 10, -1, 2}, 10)); // should be 4
    }
}
