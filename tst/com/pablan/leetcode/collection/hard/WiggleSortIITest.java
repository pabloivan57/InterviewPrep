package com.pablan.leetcode.collection.hard;

import org.junit.Test;

import java.util.Arrays;

public class WiggleSortIITest {

    @Test
    public void test() {
        int[] array = new int[] {1, 5, 1, 1, 6, 4};
        WiggleSortII wiggleSortII = new WiggleSortII();
        wiggleSortII.wiggleSort(array);
        System.out.println(Arrays.toString(array));
        array = new int[] {1, 3, 2, 2, 3, 1};
        wiggleSortII.wiggleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
