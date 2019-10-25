package com.pablan.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;

public class InsertIntervalTest {

    @Test
    public void test() {
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.toString(insertInterval.insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {2, 5})));
    }
}
