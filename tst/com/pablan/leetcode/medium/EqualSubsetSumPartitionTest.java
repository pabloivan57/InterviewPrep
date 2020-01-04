package com.pablan.leetcode.medium;

import org.junit.Test;

public class EqualSubsetSumPartitionTest {

    @Test
    public void test() {
        EqualSubsetSumPartition equalSubsetSumPartition = new EqualSubsetSumPartition();
        System.out.println(equalSubsetSumPartition.canPartition(new int[] {1, 5, 11, 5}));
        System.out.println(equalSubsetSumPartition.canPartition(new int[] {1, 2, 3, 5}));
    }
}
