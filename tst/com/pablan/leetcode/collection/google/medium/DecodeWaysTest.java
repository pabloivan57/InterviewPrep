package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class DecodeWaysTest {

    @Test
    public void test() {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12")); // should be 2
        System.out.println(decodeWays.numDecodings("226")); // should be 3
        System.out.println(decodeWays.numDecodings("0")); // should be 0
        System.out.println(decodeWays.numDecodings("06")); // should be 0
    }
}
