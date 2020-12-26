package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowMaximumTest {

    @Test
    public void test() {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindowDeque(new int[] {1,3,-1,-3,5,3,6,7}, 3))); // should be 3,3,5,5,6,7
    }
}
