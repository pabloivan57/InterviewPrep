package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class MergeIntervalsTest {

    @Test
    public void test() {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] input = new int[][] {
                {1,4},
                {0,2},
                {3,5}
        };

        int[][] result = mergeIntervals.merge(input);
        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
