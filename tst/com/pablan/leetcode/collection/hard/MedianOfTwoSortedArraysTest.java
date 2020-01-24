package com.pablan.leetcode.collection.hard;

import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void test() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
    }
}
