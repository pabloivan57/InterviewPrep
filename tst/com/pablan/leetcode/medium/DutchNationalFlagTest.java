package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class DutchNationalFlagTest {

    @Test
    public void test() {
        int[] array = new int[] {1, 0, 2, 1, 0};
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
