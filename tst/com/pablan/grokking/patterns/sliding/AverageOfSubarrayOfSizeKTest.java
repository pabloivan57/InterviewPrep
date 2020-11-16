package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class AverageOfSubarrayOfSizeKTest {

    @Test
    public void test() {
        AverageOfSubarrayOfSizeK averageOfSubarrayOfSizeK = new AverageOfSubarrayOfSizeK();
        System.out.println(averageOfSubarrayOfSizeK.findAverages(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}));
    }
}
