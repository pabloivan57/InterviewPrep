package com.pablan.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class ReverseStringTest {

    @Test
    public void test() {
        ReverseString reverseString = new ReverseString();
        System.out.println(Arrays.toString(reverseString.reverseString(new char[] {'h', 'e', 'l', 'l', 'o'})));
        System.out.println(Arrays.toString(reverseString.reverseString(new char[] {'H', 'a', 'n', 'n', 'a', 'H'})));
    }
}
