package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class MissingElementSortedArrayTest {

    @Test
    public void test() {
        MissingElementSortedArray missingElementSortedArray = new MissingElementSortedArray();
        System.out.println(missingElementSortedArray.missingElement(new int[] {4,7,9,10}, 1)); // should be 5
        System.out.println(missingElementSortedArray.missingElement(new int[] {4,7,9,10}, 3)); // should be 8
        System.out.println(missingElementSortedArray.missingElement(new int[] {1,2,4}, 3)); // should be 8
    }
}
