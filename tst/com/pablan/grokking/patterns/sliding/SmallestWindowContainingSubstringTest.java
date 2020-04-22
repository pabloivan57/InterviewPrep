package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class SmallestWindowContainingSubstringTest {

    @Test
    public void test() {
        SmallestWindowContainingSubstring smallestWindowContainingSubstring = new SmallestWindowContainingSubstring();
        System.out.println(smallestWindowContainingSubstring.findSubstring("aabdec", "abc")); // should be abdec
        System.out.println(smallestWindowContainingSubstring.findSubstring("abdabca", "abc")); // should be abc
        System.out.println(smallestWindowContainingSubstring.findSubstring("adcad", "abc")); // should be ""
    }
}
