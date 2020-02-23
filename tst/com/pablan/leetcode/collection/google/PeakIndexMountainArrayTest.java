package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class PeakIndexMountainArrayTest {

    @Test
    public void test() {
        PeakIndexMountainArray peakIndexMountainArray = new PeakIndexMountainArray();System.out.println(peakIndexMountainArray.peakIndexInMountainArray(new int[] {0,1,0})); // should be 1
        System.out.println(peakIndexMountainArray.peakIndexInMountainArray(new int[] {0,2,1,0})); // should be 2
    }
}
