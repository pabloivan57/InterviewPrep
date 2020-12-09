package com.pablan.grokking.patterns.twoheaps;

import org.junit.Test;

public class NextIntervalTest {

    @Test
    public void test() {
        NextInterval nextInterval = new NextInterval();
        System.out.println(nextInterval.findNextInterval(new int[][] {new int[] {2,3}, new int[] {3,4}, new int[] {5,6}}));
    }
}
