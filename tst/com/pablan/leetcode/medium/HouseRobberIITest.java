package com.pablan.leetcode.medium;

import org.junit.Test;

public class HouseRobberIITest {

    @Test
    public void test() {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.robRecursive(new int[] {2,3,2}));
        System.out.println(houseRobberII.rob(new int[] {1,2,3,1}));
        System.out.println(houseRobberII.rob(new int[] {1,2}));
    }
}
