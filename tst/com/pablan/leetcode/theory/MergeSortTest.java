package com.pablan.leetcode.theory;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void test() {
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(new int[] {5,2,6,1})));
    }
}
