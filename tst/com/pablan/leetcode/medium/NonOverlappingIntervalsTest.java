package com.pablan.leetcode.medium;

import org.junit.Test;

public class NonOverlappingIntervalsTest {

    @Test
    public void test() {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();

        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}}));
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
    }
}
