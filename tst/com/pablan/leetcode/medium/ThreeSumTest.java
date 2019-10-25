package com.pablan.leetcode.medium;

import org.junit.Test;

public class ThreeSumTest {

    //Given array nums = [-1, 0, 1, 2, -1, -4],
    //
    //A solution set is:
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]
    @Test
    public void test() {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
