package com.pablan.leetcode.easy;

import org.junit.Test;

public class HouseRobberTest {

    @Test
    public void test() {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[] {1,2,3,1}));
        System.out.println(houseRobber.rob(new int[] {2,7,9,3,1}));
    }
}
