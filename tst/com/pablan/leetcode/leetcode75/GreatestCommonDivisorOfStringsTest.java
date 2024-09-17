package com.pablan.leetcode.leetcode75;

import org.junit.Test;

public class GreatestCommonDivisorOfStringsTest {

    @Test
    public void test() {
        GreatestCommonDivisorOfStrings gdcStrings = new GreatestCommonDivisorOfStrings();
        String result = gdcStrings.gcdOfStrings("ABCABC", "ABD");
        System.out.println(result); // should be ABC
    }
}
