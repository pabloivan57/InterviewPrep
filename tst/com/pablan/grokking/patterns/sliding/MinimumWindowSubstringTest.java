package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class MinimumWindowSubstringTest {

    @Test
    public void test() {
        System.out.println(new MinimumWindowSubstring().findSubstring("aabdec", "abc"));
        System.out.println(new MinimumWindowSubstring().findSubstring("abdabca", "abc"));
        System.out.println(new MinimumWindowSubstring().findSubstring("adcad", "abc"));
    }
}
