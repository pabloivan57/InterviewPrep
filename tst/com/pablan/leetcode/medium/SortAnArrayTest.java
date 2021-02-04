package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class SortAnArrayTest {

    @Test
    public void test() {
        SortAnArray sortAnArray = new SortAnArray();
        System.out.println(Arrays.toString(sortAnArray.sortArray(new int[] {5,2,3,1})));
        System.out.println(Arrays.toString(sortAnArray.sortArray(new int[] {5,1,1,2,0,0})));
    }
}
