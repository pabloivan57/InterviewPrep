package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

import java.util.Arrays;

public class DutchNationalFlagTest {

    @Test
    public void test() {
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        int[] array = new int[] {2, 2, 0, 1, 2, 0};
        dutchNationalFlag.solve(array);

        System.out.println(Arrays.toString(array));
    }
}
