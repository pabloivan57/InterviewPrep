package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

import java.util.Arrays;

public class NumberRangeTest {

    @Test
    public void test() {
        NumberRange numberRange = new NumberRange();
        System.out.println(Arrays.toString(numberRange.findRange(new int[] {4, 6, 6, 6, 9}, 6))); // should be [1, 3]
        System.out.println(Arrays.toString(numberRange.findRange(new int[] {1, 3, 8, 10, 15}, 10))); // should be [3, 3]
        System.out.println(Arrays.toString(numberRange.findRange(new int[] {1, 3, 8, 10, 15}, 12))); // should be [-1, -1]
    }
}
