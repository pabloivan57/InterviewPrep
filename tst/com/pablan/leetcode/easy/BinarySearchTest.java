package com.pablan.leetcode.easy;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void test() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = new int[] { 2, 3, 4, 10, 40 };

        System.out.println(binarySearch.find(array, 40));
    }
}
