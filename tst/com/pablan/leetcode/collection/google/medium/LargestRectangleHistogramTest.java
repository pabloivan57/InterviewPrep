package com.pablan.leetcode.collection.google.medium;

import com.pablan.leetcode.collection.google.hard.LargestRectangleHistogram;
import org.junit.Test;

public class LargestRectangleHistogramTest {

    @Test
    public void test() {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[] {3, 2, 1, 2})); // should be 4
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[] {2,1,5,6,2,3})); // should be 10
    }
}
