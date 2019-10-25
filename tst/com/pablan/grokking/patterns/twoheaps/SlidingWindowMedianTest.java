package com.pablan.grokking.patterns.twoheaps;

import org.junit.Test;

public class SlidingWindowMedianTest {

    @Test
    public void test() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
