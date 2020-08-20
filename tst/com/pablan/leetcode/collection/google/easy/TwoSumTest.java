package com.pablan.leetcode.collection.google.easy;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    @Test
    public void test() {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {2, 7, 11, 15}, 9))); // should be 0, 1
    }
}
