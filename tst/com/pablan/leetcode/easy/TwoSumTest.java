package com.pablan.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    //Given nums = [2, 7, 11, 15], target = 9
    @Test
    public void test() {
        TwoSum twoSum = new TwoSum();

        int[] result = twoSum.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
        result = twoSum.twoSum(new int[] {3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));
    }
}
