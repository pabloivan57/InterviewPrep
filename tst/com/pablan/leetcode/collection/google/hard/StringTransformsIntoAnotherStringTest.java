package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class StringTransformsIntoAnotherStringTest {

    @Test
    public void test() {
        StringTransformsIntoAnotherString stringTransformsIntoAnotherString = new StringTransformsIntoAnotherString();
        //System.out.println(stringTransformsIntoAnotherString.canConvert("ace", "cea"));
        //System.out.println(stringTransformsIntoAnotherString.canConvert("aabcc", "ccdee")); // should be true
        // Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter
        System.out.println(stringTransformsIntoAnotherString.canConvert("leetcode", "codeleet")); // should be false
    }
}
