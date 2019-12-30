package com.pablan.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowMedianTest {

    @Test
    public void test() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        System.out.println(Arrays.toString(slidingWindowMedian.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
