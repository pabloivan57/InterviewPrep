package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

import java.util.Arrays;

public class CyclicSortTest {

    @Test
    public void test() {
        CyclicSort cyclicSort = new CyclicSort();

        int arr[] = new int[] {3, 1, 5, 4, 2};

        cyclicSort.sort(arr);

        System.out.println(Arrays.toString(arr));

        arr = new int[] {1, 5, 6, 4, 3, 2};

        cyclicSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
