package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class JumpGameIVTest {

    @Test
    public void test() {
        JumpGameIV jumpGameIV = new JumpGameIV();
        //System.out.println(jumpGameIV.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404})); // Should be 3
        //System.out.println(jumpGameIV.minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7})); // Should be 1
        System.out.println(jumpGameIV.minJumps(new int[]{7, 7, 7, 7, 7, 1, 2, 3}));
    }
}
