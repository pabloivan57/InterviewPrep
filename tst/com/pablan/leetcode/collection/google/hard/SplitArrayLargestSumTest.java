package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class SplitArrayLargestSumTest {

    @Test
    public void test() {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(new int[] {7,2,5,10,8}, 2)); // should be 18
        System.out.println(splitArrayLargestSum.splitArray(new int[] {1,2,3,4,5}, 2)); // should be 9
        System.out.println(splitArrayLargestSum.splitArray(new int[] {1,4,4}, 3)); // should be 4
    }
}
