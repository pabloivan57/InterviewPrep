package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class DecodeStringTest {

    @Test
    public void test() {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]")); // should be aaabcbc
    }
}
