package com.pablan.leetcode.easy;

import org.junit.Test;

public class SingleNumbersTest {

    @Test
    public void test() {
        SingleNumbers singleNumbers = new SingleNumbers();
        System.out.println(singleNumbers.singleNumber(new int[] {2,2,1}));
        System.out.println(singleNumbers.singleNumber(new int[] {4,1,2,1,2}));
    }
}
